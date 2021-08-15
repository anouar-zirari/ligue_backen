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
    public void save(@RequestBody Play play) throws Exception {
        this.playService.addYellowCard(play.getGameId(), play.getPlayerId(), play.getNumberYalowCard());
    }

    @PostMapping("/save/red-card")
    public void saveRedCard(@RequestBody Play play) throws Exception{
        //this.playService.addYellowOrRedCard(play.getGameId(), play.getPlayerId(), play.getNumberRedCard(), play.getNumberYalowCard());
        this.playService.addRedCard(play.getGameId(), play.getPlayerId(), play.getNumberRedCard());
    }


    @PostMapping("/delet/yellowOrRedCard/{redOrYellow}")
    public void removeYellowCard(@RequestBody Play play, @PathVariable("redOrYellow") String redOrYellow){
        //this.playService.removeYellowOrRedCard(play.getPlayId(), redOrYellow);
        // new code
        Long playId = play.getPlayId();
        if (redOrYellow.equals("yellow")){
            this.playService.removeYellowCard(playId);
        } else {
            this.playService.removeRedCard(play.getPlayId());
        }
    }

    // for the commission
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
