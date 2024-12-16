import demo.Connection;
import demo.WorkoutPlan;


WorkoutPlan workoutPlan = new WorkoutPlan();
Connection connection = new Connection();

public void main(String[] args) {

    connection.getExercises("");
    workoutPlan.generatePlan("", "");
    workoutPlan.printPlan();
}