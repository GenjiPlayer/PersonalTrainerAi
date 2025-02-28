package org.example.datarefactor.rabbitMQ;

import org.example.datarefactor.dto.RefactorDto;
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
    public void send(RefactorDto model) {
        rabbitTemplate.convertAndSend(inputExchange, inputAnythingRoutingKey, model, message -> {
            message.getMessageProperties().setContentType("application/json");
            return message;
        });
        System.out.println("YAHOOO! Sent: " + model);
    }
}
