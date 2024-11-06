package com.example.microserviceexam.service;
import com.example.microserviceexam.dto.userDTO;
import com.example.microserviceexam.model.userInput;
import com.example.microserviceexam.rabbitMQ.eventDispatch;
import com.example.microserviceexam.repo.userInputRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import com.example.microserviceexam.client.inputClientImp;*/

import java.util.List;
import java.util.Optional;

@Service
public class userService implements userServiceImp {
    @Autowired
    private userInputRepo userInputRepo;

    /*@Autowired
    private inputClientImp inputClientImp;*/

    @Autowired
    private eventDispatch e;

    @Override
    public userInput saveInputExternal(userInput userInput) {
        userInputRepo.save(userInput);
        userDTO userDTO = new userDTO(userInput.getGymProficiency(), userInput.getAge(), userInput.getHeight(), userInput.getCurrentWeight(), userInput.getGoalWeight());
        e.send(userDTO);
        return  userInput;
    }

    @Override
    public userInput saveInput(userInput userInput){
        return userInputRepo.save(userInput);
    }

    @Override
    public List<userInput> fetchAllUserInput(){
        return userInputRepo.findAll();
    }

    @Override
    public  userInput updateUserValues(userInput userInput, Long userId){
        userInput userDb = userInputRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userDb.setAge(userInput.getAge());
        userDb.setCurrentWeight(userInput.getCurrentWeight());
        userDb.setHeight(userInput.getHeight());
        userDb.setGoalWeight(userInput.getGoalWeight());
        userDb.setGymProficiency(userInput.getGymProficiency());
        return userInputRepo.save(userDb);
    }

    @Override
    public void deleteUserById(Long userId){
        userInputRepo.deleteById(userId);
    }
    @Override
    public Optional<userInput> fetchSingleUser(Long userId) {
        return userInputRepo.findById(userId);
    }
}
