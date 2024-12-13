package com.example.microserviceexam.rabbitMQ;

import com.example.microserviceexam.dto.userDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class userDTOConsumer {

    @Autowired
    private RestTemplate restTemplate;

    private final String refactorService = "http://localhost:8090/refactor/enriched";
    @RabbitListener(queues = "${input.queue}")
    public void recievedPayload(userDTO userdto){
        System.out.println("YIPPIIEIIEIEIEIEIEI" + userdto);


        try{
            Object res = restTemplate.postForObject(refactorService, userdto, Object.class);
            System.out.println("Response:" + res);
        } catch (Exception e){
            System.out.println("Error:" + e.getMessage());
        }
    }

}
