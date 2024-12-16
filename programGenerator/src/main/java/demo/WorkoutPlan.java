package demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Random;

public class WorkoutPlan{

    Connection connection = new Connection();
    String proficiency = "beginner";

    public static final String[] upper1 = {"chest", "middle_back", "shoulders", "lats"};
    public static final String[] lower1 = {"glutes", "hamstrings", "calves"};
    public static final String[] upper2 = {"chest", "shoulders", "triceps"};
    public static final String[] lower2 = {"glutes", "quadriceps", "abdominals"};
    public static final String[] push = {"chest", "shoulders", "triceps"};
    public static final String[] pull = {"middle_back", "lats", "biceps"};
    public static final String[] legs = {"glutes", "quadriceps", "hamstrings", "calves"};


    public void generatePlan(String jsonResponse, String muscle) {

        if (jsonResponse == null || jsonResponse.isEmpty()) {
            return;
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
                    System.out.println("No beginner exercises found for " + muscle + ". Falling back to intermediate difficulty.");
                    filteredExercises = exercises.stream()
                            .filter(exercise -> "Intermediate".equalsIgnoreCase(exercise.getDifficulty()))
                            .toList();
                }

                if (!filteredExercises.isEmpty()) {
                    Random random = new Random();
                    Exercise randomExercise = filteredExercises.get(random.nextInt(filteredExercises.size()));

                    System.out.println("Muscle: " + muscle);
                    System.out.println("Exercise: " + randomExercise.getName());
                    System.out.println("Difficulty: " + randomExercise.getDifficulty());
                    System.out.println("Instructions: " + randomExercise.getInstructions());
                    System.out.println();
                } else {
                    System.out.println("No suitable exercises found for muscle: " + muscle);
                }
            } else {
                System.out.println("No exercises found for muscle: " + muscle);
            }
        } catch (Exception e) {
            System.out.println("Error processing exercises for muscle: " + muscle);
            e.printStackTrace();
        }
    }


    public void printPlan(){

        if (proficiency == "intermediate" || proficiency == "expert") {
            System.out.println("Intro to Training program here: ///////////////////////");
            System.out.println("-------------------------------");
            System.out.println("-------------------------------");
            System.out.println("-------------------------------");

            System.out.println("===============PUSH DAY===============");
            for (String muscle : push) {
                String jsonResponse = connection.getExercises(muscle);
                generatePlan(jsonResponse, muscle);
            }
            System.out.println("===============PULL DAY===============");
            for (String muscle : pull) {
                String jsonResponse = connection.getExercises(muscle);
                generatePlan(jsonResponse, muscle);
            }
            System.out.println("===============LEG DAY===============");
            for (String muscle : legs) {
                String jsonResponse = connection.getExercises(muscle);
                generatePlan(jsonResponse, muscle);
            }
        }else if(proficiency == "beginner"){
            System.out.println("Intro to Training program here:");
            System.out.println("-------------------------------");
            System.out.println("-------------------------------");
            System.out.println("-------------------------------");
            System.out.println("===============Upper body day 1===============");
            for (String muscle : upper1) {
                String jsonResponse = connection.getExercises(muscle);
                generatePlan(jsonResponse, muscle);
            }
            System.out.println("===============Lower body day 1===============");
            for (String muscle : lower1) {
                String jsonResponse = connection.getExercises(muscle);
                generatePlan(jsonResponse, muscle);
            }
            System.out.println("===============Upper body day 2===============");
            for (String muscle : upper2) {
                String jsonResponse = connection.getExercises(muscle);
                generatePlan(jsonResponse, muscle);
            }
            System.out.println("===============Lower body day 1===============");
            for (String muscle : lower2) {
                String jsonResponse = connection.getExercises(muscle);
                generatePlan(jsonResponse, muscle);
            }
        }else System.out.println("No proficiency detected in your profile");
    }
}