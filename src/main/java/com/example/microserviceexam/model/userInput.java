package com.example.microserviceexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class userInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "cant be 0")
    private String gymProficiency;

    @Column(nullable = false)
    @NotNull(message = "cant be 0")
    @Min(value = 30, message = "cant be less than 30")
    @Max(value = 200, message = "cant be more than 200")
    private Double currentWeight;

    @Column(nullable = false)
    @NotNull(message = "cant be null")
    @Min(value = 18, message = "cant be less than 18")
    @Max(value = 100, message = "cant be more than 100")
    private Integer age;

    @Column(nullable = false)
    @NotNull(message = "cant be null")
    @Min(value = 100, message = "cant be less than 100")
    @Max(value = 250, message = "cant be more than 200")
    private Integer height;

    @Column(nullable = false)
    @NotNull(message = "cant be null")
    @Min(value = 30, message = "cant be less than 30")
    @Max(value = 200, message = "cant be more than 200")
    private Double goalWeight;
}
