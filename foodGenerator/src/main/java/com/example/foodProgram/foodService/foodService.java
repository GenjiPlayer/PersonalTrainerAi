package com.example.foodProgram.foodService;

import com.example.foodProgram.client.ExternalAPIClient;
import com.example.foodProgram.model.foodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class foodService {
    private final ExternalAPIClient externalAPIClient;

    @Autowired
    public foodService(ExternalAPIClient externalAPIClient){
        this.externalAPIClient = externalAPIClient;
    }
    public List<foodModel> generateEatingPlan(String goal) {
        if (/*something from benjamin sin ting*/) {
            return externalAPIClient.fetchGainWeightMeals();
        } else if (/*something from benjamin sin ting*/) {
            return externalAPIClient.fetchLoseWeightMeals();
        }
        throw new IllegalArgumentException("Invalid goal.");
    }
}
