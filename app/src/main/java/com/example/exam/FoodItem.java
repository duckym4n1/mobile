package com.example.exam;

public class FoodItem {
    private String foodName;
    private String nutritionalValue;
    private String calories;
    private String recommendation;

    public FoodItem(String foodName, String nutritionalValue, String calories, String recommendation) {
        this.foodName = foodName;
        this.nutritionalValue = nutritionalValue;
        this.calories = calories;
        this.recommendation = recommendation;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getNutritionalValue() {
        return nutritionalValue;
    }

    public String getCalories() {
        return calories;
    }

    public String getRecommendation() {
        return recommendation;
    }
}
