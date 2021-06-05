package com.myApp.backendLigue.service;

import com.myApp.backendLigue.entity.Sanction;
import com.myApp.backendLigue.repository.SanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SanctionService {
    @Autowired
    private SanctionRepository sanctionRepository;

    public void addYellowOrRedCardsToSanction(Long playerId, int numberOfRedCards, int numberOfYellowCard) {
        Sanction sanction = findSanctionByPlayerId(playerId);

        int numberOfYellowCardAlreadyGiven = sanction.getNumberOfYellowCard();
        int numberOfRedCardAlreadyGiven = sanction.getNumberOfRedCard();
        sanction.setNumberOfRedCard(numberOfRedCardAlreadyGiven + numberOfRedCards);
        sanction.setNumberOfYellowCard(numberOfYellowCardAlreadyGiven + numberOfYellowCard);
        sanctionRepository.save(sanction);
    }

    // la commission fait la réunion pour sanctionner un joueur
    public void applySanction(Long playerId, Long eliminationPeriod, String description){
        Sanction sanction = findSanctionByPlayerId(playerId);
        sanction.setEliminationPeriod(eliminationPeriod);
        sanction.setDescription(description);
        sanction.setExecuted(true);
        sanction.setBeginDate(new Date());
        sanctionRepository.save(sanction);
    }

    private Sanction findSanctionByPlayerId( Long playerId){
        Sanction sanction;
        List<Sanction> sanctions = sanctionRepository.findByPlayerIdAndExecuted(playerId, false);
        if (!sanctions.isEmpty()) {
            sanction = sanctions.get(0);
        } else {
            sanction = new Sanction(playerId);
        }
        return sanction;
    }
}
