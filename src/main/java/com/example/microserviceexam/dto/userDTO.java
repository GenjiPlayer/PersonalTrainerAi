package com.example.microserviceexam.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class userDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String gymProficiency;
    private Integer age;
    private Integer height;
    private Double currentWeight;
    private Double goalWeight;

    @JsonCreator
    public userDTO(
            @JsonProperty("gymProficiency") String gymProficiency,
            @JsonProperty("age") Integer age,
            @JsonProperty("height") Integer height,
            @JsonProperty("currentWeight") Double currentWeight,
            @JsonProperty("goalWeight") Double goalWeight
    ) {
        this.gymProficiency = gymProficiency;
        this.age = age;
        this.height = height;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
    }

    public static userDTO fromJsonString(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, userDTO.class);
    }
}