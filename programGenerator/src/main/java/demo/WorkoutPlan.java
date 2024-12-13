package demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Random;

public class WorkoutPlan{

    // List of muscles to fetch exercises for
    public static final String[] push = {"chest", "shoulders", "triceps"};
    public static final String[] pull = {"back", "lats", "biceps"};

    public void generatePlan(String jsonResponse, String muscle) {
        // Parse the JSON response into a List of
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Exercise> exercises = objectMapper.readValue(jsonResponse, new TypeReference<List<Exercise>>() {
            });

            if (exercises != null && !exercises.isEmpty()) {
                // Pick a random exercise
                Random random = new Random();
                Exercise randomExercise = exercises.get(random.nextInt(exercises.size()));


                // Print the random exercise
                System.out.println("Muscle: " + muscle);
                System.out.println("Exercise: " + randomExercise.getName());
                System.out.println("Difficulty: " + randomExercise.getDifficulty());
                System.out.println("Instructions: " + randomExercise.getInstructions());
                System.out.println();
            } else {
                System.out.println("No exercises found for muscle: " + muscle);
            }
        } catch (Exception e) {
            System.out.println("Error processing exercises for muscle: " + muscle);
            e.printStackTrace();
        }
    }
}