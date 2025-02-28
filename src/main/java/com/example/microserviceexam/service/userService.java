package com.example.microserviceexam.service;

import com.example.microserviceexam.dto.userDTO;
import com.example.microserviceexam.model.userInput;
import com.example.microserviceexam.rabbitMQ.eventDispatch;
import com.example.microserviceexam.service.userServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.example.microserviceexam.client.inputClient;
import com.example.microserviceexam.repo.userInputRepo;

@Service
public class userService implements userServiceImp {

    @Autowired
    private userInputRepo userInputRepo;

    @Autowired
    private eventDispatch e;

    @Override
    public Mono<userInput> saveInput(userInput userInput) {
        System.out.println("Saving user input: " + userInput);
        return Mono.fromCallable(() -> {
                    userInput savedUser = userInputRepo.save(userInput).block();
                    System.out.println("User saved successfully: " + savedUser);
                    userDTO userDTO = new userDTO(
                            savedUser.getGymProficiency(),
                            savedUser.getAge(),
                            savedUser.getHeight(),
                            savedUser.getCurrentWeight(),
                            savedUser.getGoalWeight()
                    );
                    e.send(userDTO);
                    return savedUser;
                })
                .onErrorResume(error -> {
                    System.err.println("Error saving user: " + error.getMessage());
                    return Mono.error(error);
                });
    }

    @Override
    public Flux<userInput> fetchAllUserInput() {
        return userInputRepo.findAll();
    }

    @Override
    public Mono<userInput> updateUserValues(userInput userInput, Long userId) {
        return userInputRepo.findById(userId)
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")))
                .flatMap(userDb -> {
                    userDb.setAge(userInput.getAge());
                    userDb.setCurrentWeight(userInput.getCurrentWeight());
                    userDb.setHeight(userInput.getHeight());
                    userDb.setGoalWeight(userInput.getGoalWeight());
                    userDb.setGymProficiency(userInput.getGymProficiency());
                    return userInputRepo.save(userDb);
                });
    }

    @Override
    public Mono<Void> deleteUserById(Long userId) {
        return userInputRepo.deleteById(userId);
    }

    @Override
    public Mono<userInput> fetchSingleUser(Long userId) {
        return userInputRepo.findById(userId)
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }
}