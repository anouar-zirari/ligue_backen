package com.myApp.backendLigue.controller;

import com.myApp.backendLigue.entity.Player;
import com.myApp.backendLigue.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/findAllPlayers")
    public List<Player> findAllPlayers(){
        return this.playerService.findAll();
    }
}
