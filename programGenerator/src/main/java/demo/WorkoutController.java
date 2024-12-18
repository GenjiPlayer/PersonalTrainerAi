package demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import demo.model.WorkoutModel;
import demo.rabbitMQ.eventDispatch;
import demo.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    private final WorkoutPlan workoutPlan;
    private final WorkoutRepository workoutRepository;

    @Autowired
    private eventDispatch e;

    public WorkoutController(WorkoutRepository workoutRepository, WorkoutPlan workoutPlan) {
        this.workoutRepository = workoutRepository;
        this.workoutPlan = workoutPlan;
    }
    @JsonIgnore
    @PostMapping("/generate")
    public ResponseEntity<String> generateWorkoutPlan(@RequestBody WorkoutModel requestBody) {
        workoutPlan.setProficiency(requestBody.getGymProficiency());
        System.out.println(requestBody);
        e.send(requestBody);
        String plan = workoutPlan.getWorkoutPlan();
        workoutRepository.save(requestBody);
        return ResponseEntity.ok(plan);
    }

}

