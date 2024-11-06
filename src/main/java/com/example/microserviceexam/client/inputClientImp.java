/*package com.example.microserviceexam.client;

import com.example.microserviceexam.dto.userDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;


@Component
public class inputClientImp implements inputClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String serviceURL = "http://localhost:8080/input/test";

    @Override
    public ResponseEntity<String> input(userDTO userDTO) {
        HttpEntity<userDTO> request = new HttpEntity<>(userDTO);

        return restTemplate.exchange(
                serviceURL,
                HttpMethod.POST,
                request,
                String.class
        );
    }
}*/