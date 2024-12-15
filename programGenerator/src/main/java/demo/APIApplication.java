import demo.Connection;
import demo.WorkoutPlan;

import static demo.WorkoutPlan.pull;
import static demo.WorkoutPlan.push;
import static demo.WorkoutPlan.legs;
import static demo.WorkoutPlan.upper1;
import static demo.WorkoutPlan.lower1;
import static demo.WorkoutPlan.upper2;
import static demo.WorkoutPlan.lower2;

public static void main(String[] args) {
    Connection connection = new Connection();
    WorkoutPlan workoutPlan = new WorkoutPlan();
    String proficiency = "beginner";

    if (proficiency == "intermediate" || proficiency == "expert") {
        for (String muscle : push) {
            String jsonResponse = connection.getExercises(muscle);
            workoutPlan.generatePlan(jsonResponse, muscle);
        }

        for (String muscle : pull) {
            String jsonResponse = connection.getExercises(muscle);
            workoutPlan.generatePlan(jsonResponse, muscle);
        }

        for (String muscle : legs) {
            String jsonResponse = connection.getExercises(muscle);
            workoutPlan.generatePlan(jsonResponse, muscle);
        }
    }else if(proficiency == "beginner"){
        for (String muscle : upper1) {
            String jsonResponse = connection.getExercises(muscle);
            workoutPlan.generatePlan(jsonResponse, muscle);
        }

        for (String muscle : lower1) {
            String jsonResponse = connection.getExercises(muscle);
            workoutPlan.generatePlan(jsonResponse, muscle);
        }

        for (String muscle : upper2) {
            String jsonResponse = connection.getExercises(muscle);
            workoutPlan.generatePlan(jsonResponse, muscle);
        }
        for (String muscle : lower2) {
            String jsonResponse = connection.getExercises(muscle);
            workoutPlan.generatePlan(jsonResponse, muscle);
        }
    }
}
