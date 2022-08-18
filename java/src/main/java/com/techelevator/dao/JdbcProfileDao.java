package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProfileDao implements ProfileDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserDao userDao;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }
    @Override
    @Modifying
    public Profile create(Profile profile) {
        String sql = "" +
                "INSERT INTO profile (user_id, goal_calories, current_weight, desired_weight, age, height, date_of_birth, img_url, display_name) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING user_id;";


        Integer userId = jdbcTemplate.queryForObject(sql, Integer.class,
                profile.getUserId(),
                profile.getGoalCalories(),
                profile.getCurrentWeight(),
                profile.getDesiredWeight(),
                profile.getAge(),
                profile.getHeight(),
                profile.getDateOfBirth(),
                profile.getImgUrl(),
                profile.getDisplayName());

        return get(userId);
    }

    @Override
    public Profile get(int userId) {
        String sql = "SELECT * FROM profile WHERE user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        if (rowSet.next()) {
            return mapRowToProfile(rowSet);
        }
        return null;
    }

    @Override
    public void updateProfile(int userId, Profile profile) {
        String sql = "UPDATE profile " +
                "SET goal_calories = ?, current_weight = ?, desired_weight = ?, height = ?, date_of_birth = ?, img_url = ?, display_name = ? " +
                "WHERE user_id = ?;";

        jdbcTemplate.update(sql, profile.getGoalCalories(), profile.getCurrentWeight(), profile.getDesiredWeight(), profile.getHeight(), profile.getDateOfBirth(), profile.getImgUrl(), profile.getDisplayName(), userId);
    }

    private Profile getProfileById(int profileId) {
        String sql = "SELECT * FROM profile WHERE profile_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, profileId);

        if (rowSet.next()) {
            return mapRowToProfile(rowSet);
        }
        return null;
    }

    private Profile mapRowToProfile(SqlRowSet rowSet) {
        Profile profile = new Profile();
        profile.setUserId(rowSet.getInt("user_id"));
        profile.setGoalCalories(rowSet.getInt("goal_calories"));
        profile.setCurrentWeight(rowSet.getInt("current_weight"));
        profile.setDesiredWeight(rowSet.getInt("desired_weight"));
        profile.setAge(rowSet.getInt("age"));
        profile.setHeight(rowSet.getInt("height"));
        profile.setDateOfBirth(rowSet.getDate("date_of_birth"));
        profile.setImgUrl(rowSet.getString("img_url"));
        profile.setDisplayName(rowSet.getString("display_name"));
        return profile;
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
