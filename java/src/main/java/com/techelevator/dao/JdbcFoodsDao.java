package com.techelevator.dao;

import com.techelevator.model.Foods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcFoodsDao implements FoodsDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcFoodsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
    @Override
    public Foods addFood(Foods foods) {


        String sql = "INSERT INTO foods (user_id, name, serving_size, number_of_servings, meal, calories, food_consumed)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING food_id;";

        Integer foodId = jdbcTemplate.queryForObject(sql, Integer.class,
                foods.getUserId(),
                foods.getName(),
                foods.getServingSize(),
                foods.getNumberOfServings(),
                foods.getMeal(),
                foods.getCalories(),
                foods.getFoodConsumed());

        return getFoodById(foodId);
    }

    public Foods getFoodById(int foodId) {
        String sql = "SELECT * FROM foods WHERE food_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, foodId);

        if (rowSet.next()) {
            return mapRowToFoods(rowSet);
        }
        return null;
    }

    private Foods mapRowToFoods(SqlRowSet rowSet) {
        Foods food = new Foods();
        food.setFoodId(rowSet.getInt("food_id"));
        food.setUserId(rowSet.getInt("user_id"));
        food.setName(rowSet.getString("name"));
        food.setServingSize(rowSet.getInt("serving_size"));
        food.setNumberOfServings(rowSet.getInt("number_of_servings"));
        food.setMeal(rowSet.getString("meal"));
        food.setCalories(rowSet.getInt("calories"));
        food.setFoodConsumed(rowSet.getString("food_consumed"));
        return food;
    }

    @Override
    public int findFood(int foodId) {
        return 0;
    }


//    private Foods mapRowToFoodsList(SqlRowSet rowSet) {
//    Foods myList = new Foods();
//    myList.setCalories(rowSet.getInt("calories"));
//    myList.setFoodId(rowSet.getInt("food_id"));
//    myList.setName(rowSet.getString("name"));
//    myList.setNumberOfServings(rowSet.getInt("number_of_servings"));
//    myList.setServingSize(rowSet.getInt("serving_size"));
//    myList.setProfileId(rowSet.getInt("profile_id"));
//    myList.setMeal(rowSet.getString("meal"));
//    //myList.setFoodConsumed(rowSet.getString("food_consumed"));                           ///may not need this here//
//
//
//return myList;
//    }
}
