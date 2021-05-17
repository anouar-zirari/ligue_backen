package com.myApp.backendLigue.service;


import com.myApp.backendLigue.entity.Play;
import com.myApp.backendLigue.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayService {

    @Autowired
    private PlayRepository playRepository;


    public void save(Play play){
        this.playRepository.save(play);
    }


    public Optional<Play> findById(Long id){
        return this.playRepository.findById(id);
    }


}
