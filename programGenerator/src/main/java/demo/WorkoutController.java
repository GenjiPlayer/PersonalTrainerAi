package demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    private final WorkoutPlan workoutPlan = new WorkoutPlan();

    @PostMapping("/generate")
    public ResponseEntity<String> generateWorkoutPlan(@RequestBody Exercise exercise) {
        workoutPlan.getProficiency(exercise);
        String workoutPlanResult = workoutPlan.getWorkoutPlan();
        return ResponseEntity.ok(workoutPlanResult);
    }

}

