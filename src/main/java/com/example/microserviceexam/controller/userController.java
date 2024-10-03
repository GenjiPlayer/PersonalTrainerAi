package com.example.microserviceexam.controller;
import com.example.microserviceexam.model.userInput;
import com.example.microserviceexam.service.userService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @PostMapping("/test")
    public ResponseEntity<userInput> submitUserInputExternally(@RequestBody userInput userInput){
        userInput saveUser = userService.saveInputExternal(userInput);
        return ResponseEntity.ok(saveUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<userInput>> getAllUsers(){
        List<userInput> allUsers = userService.fetchAllUserInput();
        return ResponseEntity.ok(allUsers);
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
