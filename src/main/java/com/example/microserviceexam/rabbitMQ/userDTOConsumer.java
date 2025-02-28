package com.example.microserviceexam.rabbitMQ;

import com.example.microserviceexam.dto.userDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class userDTOConsumer {

    @RabbitListener(queues = "plan")
    public void receiveMessage(Message message) {
        try {
            String jsonString = new String(message.getBody());
            System.out.println("Received message body: " + jsonString);
            userDTO user = userDTO.fromJsonString(jsonString);
            System.out.println("Received user: " + user);
        } catch (JsonProcessingException e) {
            System.err.println("Failed to deserialize message: " + e.getMessage());
        }
    }
}