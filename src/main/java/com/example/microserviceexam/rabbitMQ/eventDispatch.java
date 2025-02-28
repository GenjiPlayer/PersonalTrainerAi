package com.example.microserviceexam.rabbitMQ;

import com.example.microserviceexam.dto.userDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class eventDispatch {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${input.exchange}")
    private String inputExchange;

    @Value("${input.anything.routing-key}")
    private String inputAnythingRoutingKey;

    public void send(userDTO userDTO) {
        try {
            rabbitTemplate.convertAndSend(inputExchange, inputAnythingRoutingKey, userDTO, message -> {
                message.getMessageProperties().setContentType("application/json");
                return message;
            });
            System.out.println("Message sent: " + userDTO);
        } catch (Exception e) {
            System.err.println("Error while sending message: " + e.getMessage());
        }
    }
}