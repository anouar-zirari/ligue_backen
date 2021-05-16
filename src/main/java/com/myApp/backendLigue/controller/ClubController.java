package com.myApp.backendLigue.controller;

import com.myApp.backendLigue.entity.Club;
import com.myApp.backendLigue.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    ClubService clubService;

    @RequestMapping("/findAllClub")
    public List<Club> findAll(){
        return this.clubService.findAll();
    }

}
