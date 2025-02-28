package com.example.microserviceexam.service;

import com.example.microserviceexam.model.userInput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface userServiceImp {
    Mono<userInput> saveInput(userInput input);

    Flux<userInput> fetchAllUserInput();

    Mono<userInput> updateUserValues(userInput userInput, Long userId);

    Mono<Void> deleteUserById(Long userId);

    Mono<userInput> fetchSingleUser(Long id);
}
