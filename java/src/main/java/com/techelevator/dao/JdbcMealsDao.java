package com.techelevator.dao;

import com.techelevator.model.Foods;
import com.techelevator.model.Meals;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcMealsDao implements MealsDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcMealsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
    @Override
    public Meals addMeal(Meals meals) {


        String sql = "INSERT INTO meals (profile_id, number_of_servings, meal_name, calories)" +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING meal_id;";

        Integer mealsId = jdbcTemplate.queryForObject(sql, Integer.class,
                meals.getProfileId(),
                meals.getNumberOfServings(),
                meals.getMealName(),
                meals.getCalories());

        return getMealsById(mealsId);
    }

    public Meals getMealsById(int mealId) {
        String sql = "SELECT * FROM meals WHERE meal_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, mealId);

        if (rowSet.next()) {
            return mapRowToMeals(rowSet);
        }
        return null;
    }

    private Meals mapRowToMeals(SqlRowSet rowSet) {
        Meals meals = new Meals();
        meals.setMealId(rowSet.getInt("meal_id"));
        meals.setProfileId(rowSet.getInt("profile_id"));
        meals.setNumberOfServings(rowSet.getInt("number_of_servings"));
        meals.setMealName(rowSet.getString("meal_name"));
        meals.setCalories(rowSet.getInt("calories"));
        return meals;
    }
    }

