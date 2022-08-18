package com.techelevator.dao;

import com.techelevator.model.Profile;

public interface ProfileDao {

    Profile create(Profile profile);

    Profile get(int userId);

    void updateProfile(int userId, Profile profile);

    int calculateTotalDailyCalories (int userId);

    int calculateUserBmi(int userId);

    int addGoldStars(int userId);


}
