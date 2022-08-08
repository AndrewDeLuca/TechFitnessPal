package com.techelevator.dao;

import com.techelevator.model.Foods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcFoodsDao implements FoodsDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcFoodsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
    @Override
    public List<Foods> addFood(int userId) {
        List<Foods> listOfFoods = new ArrayList<>();

        String sql = "INSERT INTO foods WHERE user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {

            Foods list = mapRowToFoodsList(rowSet);
            listOfFoods.add(list);
        }
        return listOfFoods;

    }

    @Override
    public int findFood(int foodId) {
        return 0;
    }


    private Foods mapRowToFoodsList(SqlRowSet rowSet) {
    Foods myList = new Foods();
    myList.setCalories(rowSet.getInt("calories"));
    myList.setFoodId(rowSet.getInt("food_id"));
    myList.setName(rowSet.getString("name"));
    myList.setNumberOfServings(rowSet.getInt("number_of_servings"));
    myList.setServingSize(rowSet.getInt("serving_size"));
    myList.setProfileId(rowSet.getInt("profile_id"));
    myList.setMeal(rowSet.getString("meal"));

return myList;
    }
}
