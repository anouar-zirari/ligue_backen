package com.myApp.backendLigue.service;

import com.myApp.backendLigue.dto.GameResponse;
import com.myApp.backendLigue.entity.Game;
import com.myApp.backendLigue.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll(){
        return this.gameRepository.findAll();
    }

    public List<Game> findByRoundId(Long id){
        return this.gameRepository.findByRoundId(id);
    }

    public List<GameResponse> findClub(Long id){
        return this.gameRepository.findClubs(id);
    }
}
