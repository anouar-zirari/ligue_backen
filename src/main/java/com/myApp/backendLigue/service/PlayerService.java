package com.myApp.backendLigue.service;

import com.myApp.backendLigue.entity.Player;
import com.myApp.backendLigue.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll(){
        return this.playerRepository.findAll();
    }
}
