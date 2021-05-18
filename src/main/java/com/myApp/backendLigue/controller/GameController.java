package com.myApp.backendLigue.controller;

import com.myApp.backendLigue.entity.Game;
import com.myApp.backendLigue.repository.GameRepository;
import com.myApp.backendLigue.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/allGames")
    public List<Game> findAll(){
        return this.gameService.findAll();
    }

    @GetMapping("round/{id}")
    public List<Game> findByRoundId(@PathVariable("id") Long id){
        return this.gameService.findByRoundId(id);
    }

}
