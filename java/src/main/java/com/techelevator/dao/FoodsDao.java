package com.techelevator.dao;

import com.techelevator.model.Foods;

import java.util.List;

public interface FoodsDao {


    public Foods addFood(Foods foods);

    List<Foods> getFood();

    Foods updateFood(int food_id);

//    List<Foods> getFood(int user_id, String startDate, String endDate);
    // where startDate < food_consumed and endDate > food_consumed

    //List<Foods> getFood(int user_id, String dailyDate);
    // where food_consumed = dailyDate

    public int findFood(int foodId);





}
