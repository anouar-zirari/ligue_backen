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
    private Long playId;
    private int yellowNumber = 0;


    @Autowired
    private PlayRepository playRepository;

    @Autowired
    private PlayPlaningRepository playPlaningRepository;


    // save yellow cards
    public void save(Play play) {
        System.out.println("hellow anouar");

        if (this.check == true){

            this.playRepository.findById(this.playId).get().setNumberYalowCard(1);
            this.playRepository.save(this.playRepository.findById(this.playId).get());
            this.check = false;

        }else {

            this.playRepository.save(play);
            this.playId = play.getPlayId();

            this.check = true;

        }
    }



    // save red cards
    public void saveRedCard(Play play){
        if(this.playRepository.findById(this.playId).get().getNumberRedCard() != 1)
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
