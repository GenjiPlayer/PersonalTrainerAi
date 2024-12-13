import demo.Connection;
import demo.WorkoutPlan;

import static demo.WorkoutPlan.pull;
import static demo.WorkoutPlan.push;

public static void main(String[] args) {
    Connection connection = new Connection();
    WorkoutPlan workoutPlan = new WorkoutPlan();

    for (String muscle : push) {
        String jsonResponse = connection.getExercises(muscle); // Get JSON response
        workoutPlan.generatePlan(jsonResponse, muscle); // Process and print the plan
    }
}

