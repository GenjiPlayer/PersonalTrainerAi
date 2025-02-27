package com.example.microserviceexam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.Serial;
import java.io.Serializable;
@NoArgsConstructor
@Builder
@Data
public class userDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String gymProficiency;
    private Integer age;
    private Integer height;
    private Double currentWeight;
    private Double goalWeight;

    public userDTO(String gymProficiency, Integer age, Integer height, Double currentWeight, Double goalWeight) {
        this.gymProficiency = gymProficiency;
        this.age = age;
        this.height = height;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
    }
}