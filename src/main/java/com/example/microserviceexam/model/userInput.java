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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "cant be 0") String getGymProficiency() {
        return gymProficiency;
    }

    public void setGymProficiency(@NotNull(message = "cant be 0") String gymProficiency) {
        this.gymProficiency = gymProficiency;
    }

    public @NotNull(message = "cant be 0") @Min(value = 30, message = "cant be less than 30") @Max(value = 200, message = "cant be more than 200") Double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(@NotNull(message = "cant be 0") @Min(value = 30, message = "cant be less than 30") @Max(value = 200, message = "cant be more than 200") Double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public @NotNull(message = "cant be null") @Min(value = 18, message = "cant be less than 18") @Max(value = 100, message = "cant be more than 100") Integer getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "cant be null") @Min(value = 18, message = "cant be less than 18") @Max(value = 100, message = "cant be more than 100") Integer age) {
        this.age = age;
    }

    public @NotNull(message = "cant be null") @Min(value = 100, message = "cant be less than 100") @Max(value = 250, message = "cant be more than 200") Integer getHeight() {
        return height;
    }

    public void setHeight(@NotNull(message = "cant be null") @Min(value = 100, message = "cant be less than 100") @Max(value = 250, message = "cant be more than 200") Integer height) {
        this.height = height;
    }

    public @NotNull(message = "cant be null") @Min(value = 30, message = "cant be less than 30") @Max(value = 200, message = "cant be more than 200") Double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(@NotNull(message = "cant be null") @Min(value = 30, message = "cant be less than 30") @Max(value = 200, message = "cant be more than 200") Double goalWeight) {
        this.goalWeight = goalWeight;
    }
}
