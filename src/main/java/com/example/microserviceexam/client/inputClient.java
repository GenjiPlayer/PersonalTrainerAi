package com.example.microserviceexam.client;
import com.example.microserviceexam.dto.userDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class inputClient implements inputClientImp {

    @Autowired
    private RestTemplate restTemplate;
    private final String refactorService = "http://localhost:8081/refactor/enriched";

    @Override
    public Object refactor(userDTO userdto) {
        try{
            Object res = restTemplate.postForObject(refactorService, userdto, Object.class);
            System.out.println("YIPPIE" + res);
            return res;
        } catch (Exception e) {
            System.out.println("womp womp" + e.getMessage());
        }
        return null;
    }
}

