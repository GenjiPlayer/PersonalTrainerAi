package com.example.microserviceexam.rabbitMQ;

import com.example.microserviceexam.dto.userDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class userDTOConsumer {
    @RabbitListener(queues = "${input.queue}")
    public void recievedPayload(userDTO userdto){
        System.out.println("YIPPIIEIIEIEIEIEIEI" + userdto);

    }

}
