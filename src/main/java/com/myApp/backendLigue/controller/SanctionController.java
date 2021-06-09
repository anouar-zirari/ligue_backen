package com.myApp.backendLigue.controller;


import com.myApp.backendLigue.dto.PlayerCommissionRespons;
import com.myApp.backendLigue.service.SanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sanction")
public class SanctionController {

    @Autowired
    private SanctionService sanctionService;

    @GetMapping("/all-cards")
    public List<PlayerCommissionRespons> getAllPlayerWithCards(){
        return this.sanctionService.getAllPlayerWithCards();
    }

}
