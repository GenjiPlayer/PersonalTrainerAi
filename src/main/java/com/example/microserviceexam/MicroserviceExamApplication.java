package com.example.microserviceexam;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MicroserviceExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceExamApplication.class, args);
    }

}
