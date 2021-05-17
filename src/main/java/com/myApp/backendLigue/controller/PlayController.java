package com.myApp.backendLigue.controller;


import com.myApp.backendLigue.entity.Play;
import com.myApp.backendLigue.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/play")
public class PlayController {

    @Autowired
    private PlayService playService;

    @PostMapping("/save")
    public void save(@RequestBody Play play){
        this.playService.save(play);
    }


    @GetMapping("findById/{id}")
    public Optional<Play> findById(@PathVariable("id") Long id){
        return this.playService.findById(id);
    }

}
