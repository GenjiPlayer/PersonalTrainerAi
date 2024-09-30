package com.example.microserviceexam.service;
import com.example.microserviceexam.dto.userDTO;
import com.example.microserviceexam.model.userInput;
import com.example.microserviceexam.repo.userInputRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.microserviceexam.client.inputClientImp;

import java.util.List;

@Service
public class userService implements userServiceImp {
    @Autowired
    private userInputRepo userInputRepo;

    @Autowired
    private inputClientImp inputClientImp;

    @Override
    public userInput saveInputExternal(userInput userInput){
    userDTO userdto = new userDTO(
            userInput.getGymProficiency(),
            userInput.getCurrentWeight(),
            userInput.getAge(),
            userInput.getHeight(),
            userInput.getGoalWeight()
    );
    inputClientImp.input(userdto);
    return userInputRepo.save(userInput);
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
}
