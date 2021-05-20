package com.myApp.backendLigue.controller;

import com.myApp.backendLigue.dto.PlayerResponse;
import com.myApp.backendLigue.entity.Player;
import com.myApp.backendLigue.repository.PlayerPlaningRepository;
import com.myApp.backendLigue.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerPlaningRepository playerPlaningRepository;

    @GetMapping("/findAllPlayers")
    public List<Player> findAllPlayers(){
        return this.playerService.findAll();
    }

    @GetMapping("/findClub/{id}")
    public List<PlayerResponse> findplayerForClub(@PathVariable("id") Long id){
        return this.playerPlaningRepository.getPlayerForClub(id);
    }
}
