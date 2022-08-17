package com.techelevator.dao;

import com.techelevator.model.Foods;
import com.techelevator.model.MealsFoods;

import java.util.List;

public interface MealsFoodsDao {
    List<Foods> getFoodsByMealId(int mealId);

    MealsFoods addMealsFoods(MealsFoods mealsFoods);
}
