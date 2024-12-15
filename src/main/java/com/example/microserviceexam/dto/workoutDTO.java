package com.example.microserviceexam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class workoutDTO{
    private userDTO userId;  //mayhaps ludvik henter denne?
    private Long workoutPlanId;
}
