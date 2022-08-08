package com.techelevator.dao;

import com.techelevator.model.Profile;

public interface ProfileDao {

    public Profile create(Profile profile);

public int calculateTotalDailyCalories (int userId);


public int calculateUserBmi(int userId);


public int addGoldStars(int userId);


}
