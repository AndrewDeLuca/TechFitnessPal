package com.techelevator.controller;

import com.techelevator.dao.FoodsDao;
import com.techelevator.dao.MealsDao;
import com.techelevator.model.Foods;
import com.techelevator.model.Meals;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class MealsController {

    private final MealsDao dao;

    public MealsController(MealsDao dao) {
        this.dao = dao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/meals", method = RequestMethod.POST)
    public Meals addFood(@RequestBody Meals meals) {
       return dao.addMeal(meals);
    }

    @RequestMapping(path = "/meals", method = RequestMethod.GET)
    public List<Meals> getMeals() {
        return dao.getMeals();
    }
}

