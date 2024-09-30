package com.example.microserviceexam.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDTO {
    private String gymProficiency;
    private BigDecimal age;
    private BigDecimal height;
    private BigDecimal currentWeight;
    private BigDecimal goalWeight;
}
