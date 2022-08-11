package com.techelevator.model;

public class MealsFoods {
    private int mealFoodsId;
    private int mealId;
    private int foodId;
    private String mealFoodsName;
    private int calories;

    public int getMealFoodsId() {
        return mealFoodsId;
    }

    public void setMealFoodsId(int mealFoodsId) {
        this.mealFoodsId = mealFoodsId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getMealFoodsName() {
        return mealFoodsName;
    }

    public void setMealFoodsName(String mealFoodsName) {
        this.mealFoodsName = mealFoodsName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
