package com.techelevator.controller;


import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Profile;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProfileController {

private final ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @RequestMapping(path = "/profile", method = RequestMethod.POST)
    public Profile create(@RequestBody Profile profile) {
        return profileDao.create(profile);
    }
}
