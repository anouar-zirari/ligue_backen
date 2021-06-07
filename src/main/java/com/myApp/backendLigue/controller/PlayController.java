package com.myApp.backendLigue.controller;
import com.myApp.backendLigue.dto.PlayResponse;
import com.myApp.backendLigue.entity.Play;
import com.myApp.backendLigue.repository.PlayRepository;
import com.myApp.backendLigue.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/play")
public class PlayController {


    @Autowired
    private PlayService playService;

    @Autowired
    private PlayRepository playRepository;

    @PostMapping("/save/yellow-card")
    public void save(@RequestBody Play play){
        this.playService.addYellowOrRedCard(play.getGameId(), play.getPlayerId(), play.getNumberRedCard(), play.getNumberYalowCard());
    }

    @PostMapping("/save/red-card")
    public void saveRedCard(@RequestBody Play play){
        this.playService.addYellowOrRedCard(play.getGameId(), play.getPlayerId(), play.getNumberRedCard(), play.getNumberYalowCard());
    }

    @GetMapping("/find-play-info")
    public List<PlayResponse> getPlayInfo(){
        return this.playService.getPlayInfo();
    }

    @GetMapping("/findById/{id}")
    public Optional<Play> findById(@PathVariable("id") Long id){
        return this.playService.findById(id);
    }

    @GetMapping("/findall")
    public List<Play> findAll(){
        return this.playRepository.findAll();
    }

}
