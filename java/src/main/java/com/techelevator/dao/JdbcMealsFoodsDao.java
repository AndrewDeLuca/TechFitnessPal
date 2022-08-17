package com.techelevator.dao;

import com.techelevator.model.Foods;
import com.techelevator.model.MealsFoods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealsFoodsDao implements MealsFoodsDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcMealsFoodsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Foods> getFoodsByMealId(int mealId) {
        List<Foods> foodsList = new ArrayList<>();
        String sql = "SELECT name, serving_size, number_of_servings, meal, calories, food_consumed " +
                "FROM foods " +
                "JOIN mealsfoods USING (food_id) " +
                "WHERE meal_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, mealId);

        while (rowSet.next()) {
            foodsList.add(mapRowToFoods(rowSet));
        }

        return foodsList;
    }

    @Override
    public MealsFoods addMealsFoods(MealsFoods mealsFoods) {
        String sql = "INSERT INTO mealsfoods (meal_id, food_id, meal_foods_name, calories) " +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING meal_foods_id;";

        Integer mealFoodsId = jdbcTemplate.queryForObject(sql, Integer.class,
                mealsFoods.getMealId(),
                mealsFoods.getFoodId(),
                mealsFoods.getMealFoodsName(),
                mealsFoods.getCalories());


        return getMealsFoodsById(mealFoodsId);
    }

    private MealsFoods getMealsFoodsById(Integer mealFoodsId) {
        String sql = "SELECT * FROM mealsfoods WHERE meal_foods_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, mealFoodsId);

        if (rowSet.next()) {
            return mapRowToMealsFoods(rowSet);
        }
        return null;
    }

    private MealsFoods mapRowToMealsFoods(SqlRowSet rowSet) {
        MealsFoods mealsFoods = new MealsFoods();
        mealsFoods.setMealFoodsId(rowSet.getInt("meal_foods_id"));
        mealsFoods.setMealId(rowSet.getInt("meal_id"));
        mealsFoods.setFoodId(rowSet.getInt("food_id"));
        mealsFoods.setMealFoodsName(rowSet.getString("meal_foods_name"));
        mealsFoods.setCalories(rowSet.getInt("calories"));
        return mealsFoods;
    }

    private Foods mapRowToFoods(SqlRowSet rowSet) {
        Foods food = new Foods();
        food.setFoodId(rowSet.getInt("food_id"));
        food.setUserId(rowSet.getInt("user_id"));
        food.setName(rowSet.getString("name"));
        food.setServingSize(rowSet.getInt("serving_size"));
        food.setNumberOfServings(rowSet.getInt("number_of_servings"));
        food.setMeal(rowSet.getString("meal").toLowerCase());
        food.setCalories(rowSet.getInt("calories"));
        food.setFoodConsumed(rowSet.getString("food_consumed"));
        return food;
    }
}
