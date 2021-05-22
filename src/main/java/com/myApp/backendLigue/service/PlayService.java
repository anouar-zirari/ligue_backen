package com.myApp.backendLigue.service;


import com.myApp.backendLigue.entity.Play;
import com.myApp.backendLigue.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayService {

    // checking yellow card value
    private boolean check = false;
    private Long playId;


    @Autowired
    private PlayRepository playRepository;


    public void save(Play play) {


        if (this.check == true){

            this.playRepository.findById(this.playId).get().setNumberYalowCard(0);
            this.playRepository.findById(this.playId).get().setNumberRedCard(1);
            this.playRepository.save(this.playRepository.findById(this.playId).get());
            this.check = false;

        }else {

            this.playRepository.save(play);
            this.playId = play.getPlayId();

            this.check = true;

        }
    }


    public void saveRedCard(Play play){

        this.playRepository.save(play);

    }

    public Optional<Play> findById(Long id) {
        return this.playRepository.findById(id);
    }

}
