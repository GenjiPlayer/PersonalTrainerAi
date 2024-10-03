package com.example.microserviceexam.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String gymProficiency;
    private BigDecimal age;
    private BigDecimal height;
    private BigDecimal currentWeight;
    private BigDecimal goalWeight;
}
