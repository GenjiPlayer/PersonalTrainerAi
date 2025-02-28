package com.example.microserviceexam.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "USER_INPUT")
public class userInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Gym proficiency cannot be null")
    private String gymProficiency;

    @Column(nullable = false)
    @NotNull(message = "Current weight cannot be null")
    @Min(value = 30, message = "Current weight cannot be less than 30")
    @Max(value = 200, message = "Current weight cannot be more than 200")
    private Double currentWeight;

    @Column(nullable = false)
    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age cannot be less than 18")
    @Max(value = 100, message = "Age cannot be more than 100")
    private Integer age;

    @Column(nullable = false)
    @NotNull(message = "Height cannot be null")
    @Min(value = 100, message = "Height cannot be less than 100")
    @Max(value = 250, message = "Height cannot be more than 250")
    private Integer height;

    @Column(nullable = false)
    @NotNull(message = "Goal weight cannot be null")
    @Min(value = 30, message = "Goal weight cannot be less than 30")
    @Max(value = 200, message = "Goal weight cannot be more than 200")
    private Double goalWeight;
}