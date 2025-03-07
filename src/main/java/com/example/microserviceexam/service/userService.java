package com.example.microserviceexam.service;

import com.example.microserviceexam.client.inputClient;
import com.example.microserviceexam.dto.userDTO;
import com.example.microserviceexam.model.userInput;
import com.example.microserviceexam.rabbitMQ.eventDispatch;
import com.example.microserviceexam.repo.userInputRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService implements userServiceImp {

    @Autowired
    private userInputRepo userInputRepo;

    @Autowired
    private inputClient inputClient;

    @Autowired
    private eventDispatch e;

    @Override
    public userInput saveInput(userInput userInput) {
        userDTO userDTO = new userDTO(
                userInput.getGymProficiency(),
                userInput.getAge(),
                userInput.getHeight(),
                userInput.getCurrentWeight(),
                userInput.getGoalWeight()
        );

        System.out.println("Saving user input: " + userInput);
        userInput savedUser = userInputRepo.save(userInput);
        System.out.println("Calling refactor service synchronously...");
        Object refactoredResponse = inputClient.refactor(userDTO).block();
        System.out.println("Refactor service response: " + refactoredResponse);

        return savedUser;
    }
    @Override
    public List<userInput> fetchAllUserInput() {
        return userInputRepo.findAll();
    }

    @Override
    public userInput updateUserValues(userInput userInput, Long userId) {
        com.example.microserviceexam.model.userInput userDb = userInputRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userDb.setAge(userInput.getAge());
        userDb.setCurrentWeight(userInput.getCurrentWeight());
        userDb.setHeight(userInput.getHeight());
        userDb.setGoalWeight(userInput.getGoalWeight());
        userDb.setGymProficiency(userInput.getGymProficiency());
        return userInputRepo.save(userDb);
    }

    @Override
    public void deleteUserById(Long userId) {
        userInputRepo.deleteById(userId);
    }

    @Override
    public Optional<userInput> fetchSingleUser(Long userId) {
        return userInputRepo.findById(userId);
    }
}
