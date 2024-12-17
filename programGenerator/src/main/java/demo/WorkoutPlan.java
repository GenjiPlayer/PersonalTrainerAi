package demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

public class WorkoutPlan {


    private final Connection connection = new Connection();
    private final String ProgramGenerator = "http://localhost:8090/refactor/send-to-generator";
    private String proficiency;
    public RestTemplate restTemplate;

    public static final String[] upper1 = {"chest", "middle_back", "shoulders", "lats"};
    public static final String[] lower1 = {"glutes", "hamstrings", "calves"};
    public static final String[] upper2 = {"chest", "shoulders", "triceps"};
    public static final String[] lower2 = {"glutes", "quadriceps", "abdominals"};
    public static final String[] push = {"chest", "shoulders", "triceps"};
    public static final String[] pull = {"middle_back", "lats", "biceps"};
    public static final String[] legs = {"glutes", "quadriceps", "hamstrings", "calves"};

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getProficiency(Exercise exercise) {
        try {
            return restTemplate.postForObject(ProgramGenerator, exercise, String.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getWorkoutPlan() {
        System.out.println("Proficiency: " + proficiency); // Debugging
        StringBuilder workoutPlanOutput = new StringBuilder();

        if ("intermediate".equalsIgnoreCase(proficiency) || "expert".equalsIgnoreCase(proficiency)) {
            workoutPlanOutput.append("Intro to Training program here:\n")
                    .append("-------------------------------\n")
                    .append("=================PUSH DAY===============\n");
            for (String muscle : push) {
                String jsonResponse = connection.getExercises(muscle);
                workoutPlanOutput.append(generatePlan(jsonResponse, muscle));
            }
            workoutPlanOutput.append("=================PULL DAY===============\n");
            for (String muscle : pull) {
                String jsonResponse = connection.getExercises(muscle);
                workoutPlanOutput.append(generatePlan(jsonResponse, muscle));
            }
            workoutPlanOutput.append("=================LEG DAY===============\n");
            for (String muscle : legs) {
                String jsonResponse = connection.getExercises(muscle);
                workoutPlanOutput.append(generatePlan(jsonResponse, muscle));
            }

        } else if ("beginner".equalsIgnoreCase(proficiency)) {
            workoutPlanOutput.append("Intro to Training program here:\n")
                    .append("-------------------------------\n")
                    .append("=================Upper body day 1===============\n");
            for (String muscle : upper1) {
                String jsonResponse = connection.getExercises(muscle);
                workoutPlanOutput.append(generatePlan(jsonResponse, muscle));
            }
            workoutPlanOutput.append("=================Lower body day 1===============\n");
            for (String muscle : lower1) {
                String jsonResponse = connection.getExercises(muscle);
                workoutPlanOutput.append(generatePlan(jsonResponse, muscle));
            }
            workoutPlanOutput.append("=================Upper body day 2===============\n");
            for (String muscle : upper2) {
                String jsonResponse = connection.getExercises(muscle);
                workoutPlanOutput.append(generatePlan(jsonResponse, muscle));
            }
            workoutPlanOutput.append("=================Lower body day 2===============\n");
            for (String muscle : lower2) {
                String jsonResponse = connection.getExercises(muscle);
                workoutPlanOutput.append(generatePlan(jsonResponse, muscle));
            }
        } else {
            System.out.println("proficiency is not beginner or intermediate. Or it is not found" + proficiency);
        }
        return workoutPlanOutput.toString();
    }

    public String generatePlan(String jsonResponse, String muscle) {
        StringBuilder result = new StringBuilder();

        if (jsonResponse == null || jsonResponse.isEmpty()) {
            return "No exercises found for muscle: " + muscle + "\n";
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Exercise> exercises = objectMapper.readValue(jsonResponse, new TypeReference<List<Exercise>>() {});

            if (exercises != null && !exercises.isEmpty()) {
                List<Exercise> filteredExercises = exercises;
                if ("beginner".equalsIgnoreCase(proficiency)) {
                    filteredExercises = exercises.stream()
                            .filter(exercise -> "Beginner".equalsIgnoreCase(exercise.getDifficulty()))
                            .toList();
                }
                if (filteredExercises.isEmpty()) {
                    result.append("No beginner exercises found for ").append(muscle)
                            .append(". Falling back to intermediate difficulty.\n");
                    filteredExercises = exercises.stream()
                            .filter(exercise -> "Intermediate".equalsIgnoreCase(exercise.getDifficulty()))
                            .toList();
                }

                if (!filteredExercises.isEmpty()) {
                    Random random = new Random();
                    Exercise randomExercise = filteredExercises.get(random.nextInt(filteredExercises.size()));

                    result.append("Muscle: ").append(muscle).append("\n")
                            .append("Exercise: ").append(randomExercise.getName()).append("\n")
                            .append("Difficulty: ").append(randomExercise.getDifficulty()).append("\n")
                            .append("Instructions: ").append(randomExercise.getInstructions()).append("\n\n");
                } else {
                    result.append("No suitable exercises found for muscle: ").append(muscle).append("\n");
                }
            } else {
                result.append("No exercises found for muscle: ").append(muscle).append("\n");
            }
        } catch (Exception e) {
            result.append("Error processing exercises for muscle: ").append(muscle).append("\n");
            e.printStackTrace();
        }

        return result.toString();
    }
}
