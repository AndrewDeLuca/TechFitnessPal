package com.techelevator.controller;


import com.techelevator.dao.FoodsDao;
import com.techelevator.model.Foods;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class FoodsController {
    private final FoodsDao dao;

    public FoodsController(FoodsDao dao) {
        this.dao = dao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/foods", method = RequestMethod.POST)
    public Foods addFood(@RequestBody Foods foods) {
        return dao.addFood(foods);
    }
}
