package org.example.datarefactor.rabbitMQ;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.datarefactor.dto.RefactorDto;
import org.example.datarefactor.model.RefactorModel;
import org.example.datarefactor.repository.RefactorRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class consumer {
    @Autowired
    private RefactorRepository refactorRepo;

    @Autowired
    private eventDispatch eventDispatch;

    @RabbitListener(queues = "plan")
    public void processUserDTO(JsonNode userData) {
        try {
            String gymProficiency = userData.get("gymProficiency").asText();
            Integer age = userData.get("age").asInt();
            String refactoredProficiency = gymProficiency.equals("beginner") ? "intermediate" : gymProficiency;
            RefactorModel refactorModel = new RefactorModel();
            refactorModel.setGymProficiency(refactoredProficiency);
            refactorModel.setAge(age);
            refactorRepo.save(refactorModel);
            eventDispatch.send(RefactorDto.builder().build());

            System.out.println("Processed and refactored user data: " + refactorModel);
        } catch (Exception e) {
            System.err.println("Error processing user data: " + e.getMessage());
        }
    }
}