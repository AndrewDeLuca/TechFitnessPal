package com.techelevator.dao;

import com.techelevator.model.Foods;
import com.techelevator.model.Meals;

import java.util.List;

public interface MealsDao {

    public Meals addMeal(Meals meals);

    List<Meals> getMeals();
}
