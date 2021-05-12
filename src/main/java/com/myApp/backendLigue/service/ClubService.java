package com.myApp.backendLigue.service;

import com.myApp.backendLigue.entity.Club;
import com.myApp.backendLigue.repository.ClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    ClubRepo clubRepository;

    public List<Club> findAll(){
        return this.clubRepository.findAll();
    }

}
