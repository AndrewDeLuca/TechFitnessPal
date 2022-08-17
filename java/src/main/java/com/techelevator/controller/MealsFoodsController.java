package com.techelevator.controller;

import com.techelevator.dao.FoodsDao;
import com.techelevator.dao.MealsDao;
import com.techelevator.dao.MealsFoodsDao;
import com.techelevator.model.Foods;
import com.techelevator.model.MealsFoods;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MealsFoodsController {
    private final MealsFoodsDao mealsFoodsDao;
    private final MealsDao mealsDao;
    private final FoodsDao foodsDao;


    public MealsFoodsController(MealsFoodsDao mealsFoodsDao, MealsDao mealsDao, FoodsDao foodsDao) {
        this.mealsFoodsDao = mealsFoodsDao;
        this.mealsDao = mealsDao;
        this.foodsDao = foodsDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/mealsfoods", method = RequestMethod.POST)
    public MealsFoods addMealsFoods(@RequestBody MealsFoods mealsFoods) {
        return mealsFoodsDao.addMealsFoods(mealsFoods);
    }

    @RequestMapping(path = "/mealsfoods/{meal_id}", method = RequestMethod.GET)
    public List<Foods> getFoodsByMealId(@PathVariable int meal_id) {
        return mealsFoodsDao.getFoodsByMealId(meal_id);
    }
}
