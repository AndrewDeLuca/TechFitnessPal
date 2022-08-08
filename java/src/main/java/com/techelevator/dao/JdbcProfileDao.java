package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcProfileDao implements ProfileDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Profile create(Profile profile) {
        String sql = "INSERT INTO profile (profile_id, user_id, goal_calories, current_weight, desired_weight, age, height) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        Profile newProfile = jdbcTemplate.queryForObject(sql, Profile.class, profile.getProfileId(),
                profile.getUserId(),
                profile.getGoalCalories(),
                profile.getCurrentWeight(),
                profile.getDesiredWeight(),
                profile.getAge(),
                profile.getHeight());


        return newProfile;
    }

    @Override
    public int calculateTotalDailyCalories(int userId) {
        return 0;
    }

    @Override
    public int calculateUserBmi(int userId) {
        return 0;
    }

    @Override
    public int addGoldStars(int userId) {
        return 0;
    }
}
