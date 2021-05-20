package com.myApp.backendLigue.controller;

import com.myApp.backendLigue.dto.GameResponse;
import com.myApp.backendLigue.entity.Game;
import com.myApp.backendLigue.repository.GamePlaningRepository;
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

    @Autowired
    private GamePlaningRepository gamePlaningRepository;

    @GetMapping("/allGames")
    public List<Game> findAll(){
        return this.gameService.findAll();
    }

    // return all the games of the round
    @GetMapping("round/{id}")
    public List<Game> findByRoundId(@PathVariable("id") Long id){
        return this.gameService.findByRoundId(id);
    }

    // return all the club of the games in one round
    @GetMapping("games-for-round/{id}")
    public List<GameResponse> getClubForRound(@PathVariable("id") Long id){
        return this.gamePlaningRepository.getGamesForRound(id);
    }


}
