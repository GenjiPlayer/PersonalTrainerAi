package demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import demo.model.WorkoutModel;
import demo.rabbitMQ.eventDispatch;
import demo.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/workout")
@CrossOrigin(origins = "*")
public class WorkoutController {

    private final WorkoutPlan workoutPlan;
    private final WorkoutRepository workoutRepository;

    @Autowired
    private eventDispatch e;

    public WorkoutController(WorkoutRepository workoutRepository, WorkoutPlan workoutPlan) {
        this.workoutRepository = workoutRepository;
        this.workoutPlan = workoutPlan;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateWorkoutPlan(@RequestBody WorkoutModel requestBody) {
        workoutPlan.setProficiency(requestBody.getGymProficiency());
        System.out.println("Received workout request: " + requestBody);
        CompletableFuture.runAsync(() -> {
            e.send(requestBody);
            workoutRepository.save(requestBody);
        }).exceptionally(error -> {
            System.out.println("Error saving workout request: " + error.getCause().getMessage());
            return null;
        });

        return ResponseEntity.ok(workoutPlan.getWorkoutPlan());
    }
}

