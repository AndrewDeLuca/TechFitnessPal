package com.techelevator.dao;

import com.techelevator.model.Foods;

import java.util.List;

public interface FoodsDao {


    public Foods addFood(Foods foods);

    List<Foods> getFood();

    Foods updateFood(int food_id);



    public int findFood(int foodId);





}
