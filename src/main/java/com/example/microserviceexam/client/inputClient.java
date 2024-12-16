package com.example.microserviceexam.client;
import com.example.microserviceexam.dto.userDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class inputClient implements inputClientImp {
    @Autowired
    private RestTemplate restTemplate;

<<<<<<< HEAD
    private final String refactorService = "http://localhost:8090/refactor/enriched";

    @Override
    public void refactor(userDTO userdto) {
        try{
            Object res = restTemplate.postForObject(refactorService, userdto, Object.class);
            System.out.println("YIPPIE" + res);
        } catch (Exception e) {
            System.out.println("womp womp" + e.getMessage());
        }
    }

}

