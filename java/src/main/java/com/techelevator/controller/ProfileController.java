package com.techelevator.controller;


import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class ProfileController {
    private final ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/profile", method = RequestMethod.POST)
    public Profile create(@RequestBody Profile profile) {
        return profileDao.create(profile);
    }

    @RequestMapping(path = "/profile/{userId}", method = RequestMethod.GET)
    public Profile get(@PathVariable int userId) {
        return profileDao.get(userId);
    }
}
