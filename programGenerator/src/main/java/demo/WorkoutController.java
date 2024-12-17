package demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    private final WorkoutPlan workoutPlan = new WorkoutPlan();

    @PostMapping("/generate")
    public ResponseEntity<String> generateWorkoutPlan(@RequestBody Exercise exercise) {
        String proficiency = workoutPlan.getProficiency(exercise);
        workoutPlan.setProficiency(proficiency);
        String workoutPlanResult = workoutPlan.getWorkoutPlan();
        return ResponseEntity.ok(workoutPlanResult);
    }

    @GetMapping("/generate")
    public ResponseEntity<String> getWorkoutPlan(@RequestBody Exercise exercise){
        String proficiency = workoutPlan.getProficiency(exercise);
        workoutPlan.setProficiency(proficiency);
        String workoutPlanResult = workoutPlan.getWorkoutPlan();
        return ResponseEntity.ok(workoutPlanResult);
    }

}

