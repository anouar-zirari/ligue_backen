package com.myApp.backendLigue.controller;

import com.myApp.backendLigue.entity.Round;
import com.myApp.backendLigue.repository.RoundRepository;
import com.myApp.backendLigue.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/round")
public class RoundConroller {

    @Autowired
    RoundService roundService;

    @GetMapping("/findAllRounds")
    public List<Round> findAllRounds(){
        return this.roundService.findAllRounds();
    }
}
