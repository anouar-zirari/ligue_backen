package com.myApp.backendLigue.service;

import com.myApp.backendLigue.entity.Round;
import com.myApp.backendLigue.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundService {

    @Autowired
    RoundRepository roundRepository;

    public List<Round> findAllRounds(){
        return this.roundRepository.findAll();
    }

}
