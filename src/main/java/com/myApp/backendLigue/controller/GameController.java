package com.myApp.backendLigue.controller;

import com.myApp.backendLigue.entity.Game;
import com.myApp.backendLigue.repository.GameRepository;
import com.myApp.backendLigue.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    public List<Game> findAll(){
        return this.gameService.findAll();
    }
}
