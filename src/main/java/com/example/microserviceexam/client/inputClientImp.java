package com.example.microserviceexam.client;

import com.example.microserviceexam.dto.userDTO;
import com.example.microserviceexam.model.userInput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface inputClientImp {

  Object refactor(userDTO userDTO);
}