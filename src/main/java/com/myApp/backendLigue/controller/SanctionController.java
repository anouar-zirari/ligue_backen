package com.myApp.backendLigue.controller;


import com.myApp.backendLigue.dto.PlayerCommissionRespons;
import com.myApp.backendLigue.entity.Sanction;
import com.myApp.backendLigue.service.SanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/apply-sanction")
    public void applySanction(@RequestBody Sanction sanction){
        this.sanctionService.applySanction(
                sanction.getPlayerId(), sanction.getEliminationPeriod(), sanction.getDescription());
    }

}
