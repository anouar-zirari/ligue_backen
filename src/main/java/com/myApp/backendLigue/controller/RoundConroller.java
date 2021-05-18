package com.myApp.backendLigue.controller;

import com.myApp.backendLigue.entity.Round;
import com.myApp.backendLigue.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/round")
public class RoundConroller {

    @Autowired
    private RoundService roundService;

    @GetMapping("/findAllRounds")
    public List<Round> findAllRounds(){
        return this.roundService.findAllRounds();
    }
}
