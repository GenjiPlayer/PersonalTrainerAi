package demo;

import demo.model.WorkoutModel;
import demo.repository.WorkoutRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    private final WorkoutPlan workoutPlan;
    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository, WorkoutPlan workoutPlan) {
        this.workoutRepository = workoutRepository;
        this.workoutPlan = workoutPlan;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateWorkoutPlan(@RequestBody Map<String, String> requestBody) {
        String gymProficiency = requestBody.get("gymProficiency");

        workoutPlan.setProficiency(gymProficiency);
        String plan = workoutPlan.getWorkoutPlan();
        return ResponseEntity.ok(plan);
    }

    @GetMapping("/generate")
    public ResponseEntity<String> getWorkoutPlan(@RequestBody Exercise exercise){
        String proficiency = workoutPlan.getProficiency(exercise);
        workoutPlan.setProficiency(proficiency);
        String workoutPlanResult = workoutPlan.getWorkoutPlan();
        return ResponseEntity.ok(workoutPlanResult);
    }

}

