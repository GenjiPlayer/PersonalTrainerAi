package com.example.foodProgram.model;

public class foodModel {
    private String name;
    private String ingredients;
    private String instructions;
    private String servings;

    public foodModel(String name, String ingredients, String instructions, String servings) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.servings = servings;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public String getServings() {
        return servings;
    }
    public void setServings(String servings) {
        this.servings = servings;
    }
}
