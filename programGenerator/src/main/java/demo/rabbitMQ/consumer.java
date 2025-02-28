package demo.rabbitMQ;

import com.fasterxml.jackson.databind.JsonNode;
import demo.model.WorkoutModel;
import demo.repository.WorkoutRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class consumer {
    @Autowired
    private WorkoutRepository workoutPlanRepo;

    @RabbitListener(queues = "plan")
    public void processRefactoredData(JsonNode refactoredData) {
        try {
            Long id = refactoredData.get("id").asLong();
            String gymProficiency = refactoredData.get("gymProficiency").asText();
            String workoutPlan = gymProficiency.equals("intermediate") ? "Intermediate Plan" : "Beginner Plan";
            WorkoutModel workout = new WorkoutModel();
            workout.setUserId(id);
            workout.setWorkoutPlan(workoutPlan);
            workoutPlanRepo.save(workout);

            System.out.println("Generated workout plan: " + workout);
        } catch (Exception e) {
            System.err.println("Error generating workout plan: " + e.getMessage());
        }
    }
}