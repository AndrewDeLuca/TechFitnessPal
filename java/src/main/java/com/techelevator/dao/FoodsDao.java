package com.techelevator.dao;

import com.techelevator.model.Foods;

public interface FoodsDao {


    public Foods addFood(Foods foods);

    Foods getFoodByMeal(String meal);



    public int findFood(int foodId);





}
