package com.example.microserviceexam.controller;

import com.example.microserviceexam.model.userInput;
import com.example.microserviceexam.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/input")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/submit")
    public Mono<ResponseEntity<userInput>> submitUserInput(@RequestBody userInput userInput) {
        System.out.println("Received user input: " + userInput);
        return userService.saveInput(userInput)
                .map(ResponseEntity::ok)
                .onErrorResume(error -> {
                    System.err.println("Error saving user input: " + error.getMessage());
                    return Mono.just(ResponseEntity.badRequest().build());
                });
    }

    @GetMapping("/all")
    public Flux<userInput> getAllUsers() {
        return userService.fetchAllUserInput();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<userInput>> getSingleUser(@PathVariable Long id) {
        return userService.fetchSingleUser(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<userInput>> updateUserInput(@RequestBody userInput userInput, @PathVariable Long id) {
        return userService.updateUserValues(userInput, id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}