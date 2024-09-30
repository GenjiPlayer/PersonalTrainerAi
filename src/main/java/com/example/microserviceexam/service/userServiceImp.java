package com.example.microserviceexam.service;

import com.example.microserviceexam.model.userInput;

import java.util.List;

public interface userServiceImp {
    userInput saveInputExternal(userInput userInput);

    userInput saveInput(userInput input);
    List<userInput> fetchAllUserInput();
    userInput updateUserValues(userInput userInput, Long userId);

    void deleteUserById(Long userId);
}
