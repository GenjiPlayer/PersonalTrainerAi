package com.example.microserviceexam.controller;
import com.example.microserviceexam.model.userInput;
import com.example.microserviceexam.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/input")
@CrossOrigin(origins = "http://localhost:3000")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/submit")
    public ResponseEntity<userInput> submitUserInput(@RequestBody userInput userInput){
        userInput savedUser = userService.saveInput(userInput);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<userInput>> getAllUsers(){
        List<userInput> allUsers = userService.fetchAllUserInput();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<userInput>> getSingleUser(@PathVariable Long id){
        Optional<userInput> singleUser = userService.fetchSingleUser(id);
        return ResponseEntity.ok(singleUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<userInput> updateUserInput(@RequestBody userInput userInput, @PathVariable Long id){
        userInput updateUser = userService.updateUserValues(userInput, id);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
