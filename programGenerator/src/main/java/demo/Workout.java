package demo;

public class Workout {
    private String name;
    private String muscleGroup;
    private String difficulty;
    private String equipment;

    public Workout(String name, String muscleGroup, String difficulty, String equipment) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.difficulty = difficulty;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getEquipment() {
        return equipment;
    }

    @Override
    public String toString() {
        return name + " (" + muscleGroup + ", " + difficulty + ", " + equipment + ")";
    }
}
