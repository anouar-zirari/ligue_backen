package com.myApp.backendLigue.controller;

import com.myApp.backendLigue.dto.*;
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

    @GetMapping("/find-player-for-Club/{id}")
    public List<PlayerResponse> findplayerForClub(@PathVariable("id") Long id){
        return this.playerPlaningRepository.getPlayerForClub(id);
    }

    @GetMapping("/round/{id}")
    public List<PlayerWithReportResponse> getPlayersWithReportForRound(@PathVariable("id") Long id){
       return this.playerPlaningRepository.getPlayerWithReportForRound(id);
    }

    @GetMapping("/game/yellow-cards/{id}")
    public List<PlayerWithYellowCard> getPlayerWithYellowCardForGame(@PathVariable("id") Long gameId){
        return this.playerPlaningRepository.getPlayerWithYellowCardForGame(gameId);
    }

    @GetMapping("/game/red-cards/{id}")
    public List<PlayerWithRedCard> getPlayerWithRedCardForGame(@PathVariable("id") Long gameId){
        return this.playerPlaningRepository.getPlayerWithRedCardForGame(gameId);
    }

    @GetMapping("/club/{clubId}")
    public List<PlayerOfClubInfo> getPlayerOfClubWithInfos(@PathVariable("clubId") Long clubId){
        return this.playerPlaningRepository.getPlayerOfClubInfo(clubId);
    }

}
