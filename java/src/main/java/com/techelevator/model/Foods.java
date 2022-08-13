package com.techelevator.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.security.Timestamp;
import java.util.Date;

public class Foods {

    @NotEmpty
    private String name;
    @NotEmpty
    private int servingSize;
    @NotEmpty
    private int numberOfServings;
    private String meal;
    @NotEmpty
    private int calories;
    @NotEmpty
    private int foodId;
    private String foodConsumed;
    private int userId;

    public String getFoodConsumed() {
        return foodConsumed;
    }

    public void setFoodConsumed(String foodConsumed) {
        this.foodConsumed = foodConsumed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public int getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
