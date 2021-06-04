package com.myApp.backendLigue.service;


import com.myApp.backendLigue.dto.PlayResponse;
import com.myApp.backendLigue.entity.Play;
import com.myApp.backendLigue.repository.PlayPlaningRepository;
import com.myApp.backendLigue.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayService {

    // checking yellow card value
    private boolean check = false;
    private Long playRedId;
    private Long playYellowId;
    private int yellowNumber = 0;


    @Autowired
    private PlayRepository playRepository;

    @Autowired
    private PlayPlaningRepository playPlaningRepository;


    // save yellow card (4 yellow count 1 red)
    public void save(Play play){
        if (!this.playRepository.findAll().isEmpty()) {
            this.playRepository.findAll().forEach(p -> {
                if (p.getPlayerId() == play.getPlayerId() && p.getNumberYalowCard() <= 3) {
                    System.out.println("this player " + play.getPlayerId() + " exist in the database" + "hes play id is"
                    + p.getPlayId());
                   // this.playYellowId = p.getPlayId();
                    this.playRepository.findById(p.getPlayId()).get().
                            setNumberYalowCard(this.playRepository.findById(p.getPlayId()).get().getNumberYalowCard() + 1);
                    this.playRepository.save(this.playRepository.findById(p.getPlayId()).get());

                } else if (p.getNumberYalowCard() == 4){
                    System.out.println("this player hes 3 yellow cards");
                    this.playRepository.findById(p.getPlayId()).get().setNumberRedCard(1);
                    this.playRepository.findById(p.getPlayId()).get().setNumberYalowCard(0);
                    this.playRepository.save(this.playRepository.findById(p.getPlayId()).get());

                }else{
                    System.out.println("this player not exist in the database " + play.getPlayerId());
                    this.playRepository.save(play);
                }
            });
        }else{
            System.out.println("your out of the for each loop");
            this.playRepository.save(play);
        }
    }



    // save red cards
    public void saveRedCard(Play play){
        if(this.playRepository.findById(this.playRedId).get().getNumberRedCard() != 1)
            this.playRepository.save(play);

    }

    // return all player with red and yellow card number
    public List<PlayResponse> getPlayInfo(){
        return this.playPlaningRepository.getPlayInfo();
    }


    // find play by id
    public Optional<Play> findById(Long id) {
        return this.playRepository.findById(id);
    }

}
