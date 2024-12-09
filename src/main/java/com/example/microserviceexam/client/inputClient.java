package com.example.microserviceexam.client;

import com.example.microserviceexam.dto.userDTO;
import org.springframework.http.ResponseEntity;

public interface inputClient {
   ResponseEntity<String> input(userDTO userDTO);
}//kkgkgkg