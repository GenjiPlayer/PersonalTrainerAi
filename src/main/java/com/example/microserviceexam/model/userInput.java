package com.example.microserviceexam.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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
    private String gymProficiency;


    @Column(nullable = false)
    private BigDecimal currentWeight;


    @Column(nullable = false)
    private BigDecimal age;


    @Column(nullable = false)
    private BigDecimal height;


    @Column(nullable = false)
    private BigDecimal goalWeight;

}
