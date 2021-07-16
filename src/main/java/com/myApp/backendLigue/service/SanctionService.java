package com.myApp.backendLigue.service;

import com.myApp.backendLigue.dto.PlayerCommissionRespons;
import com.myApp.backendLigue.entity.Sanction;
import com.myApp.backendLigue.repository.PlayerCommissionRepository;
import com.myApp.backendLigue.repository.SanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class SanctionService {
    @Autowired
    private SanctionRepository sanctionRepository;

    @Autowired
    private PlayerCommissionRepository playerCommissionRepository;

    public void addYellowOrRedCardsToSanction(Long playerId, int numberOfRedCards, int numberOfYellowCard) {
        Sanction sanction = findSanctionByPlayerId(playerId);

        int numberOfYellowCardAlreadyGiven = sanction.getNumberOfYellowCard();
        int numberOfRedCardAlreadyGiven = sanction.getNumberOfRedCard();
        sanction.setNumberOfRedCard(numberOfRedCardAlreadyGiven + numberOfRedCards);
        sanction.setNumberOfYellowCard(numberOfYellowCardAlreadyGiven + numberOfYellowCard);
        int numberOfYellowCardAfterUpdate = sanction.getNumberOfYellowCard();
        if(numberOfYellowCardAfterUpdate == 4){
            sanction.setNumberOfRedCard(1);
        }
        sanctionRepository.save(sanction);
    }

    public void removeYellowOrRedCardToSanction
            (Long playerId, String yellowOrRedCard, int numberOfRedCard, int numberOfYellowCard){
        Sanction sanction = findSanctionByPlayerId(playerId);
        int numberOfYellowCardGiven = sanction.getNumberOfYellowCard();
        if( (numberOfRedCard > 0 || numberOfYellowCard > 0) && yellowOrRedCard.equals("yellow")){
            sanction.setNumberOfYellowCard(numberOfYellowCardGiven - numberOfYellowCard);
            sanction.setNumberOfRedCard(numberOfRedCard);
            this.sanctionRepository.save(sanction);
        }else if(numberOfRedCard == 0 && numberOfYellowCardGiven == 0){
            this.sanctionRepository.delete(sanction);
        }else if(yellowOrRedCard.equals("red") && numberOfRedCard > 0){
            sanction.setNumberOfRedCard(numberOfRedCard - 1);
            this.sanctionRepository.save(sanction);
            int numberOfRedCardUpdated = sanction.getNumberOfRedCard();
            if (numberOfRedCardUpdated == 0 && numberOfYellowCard == 0) {
                this.sanctionRepository.delete(sanction);
            }
        }
    }

    // la commission fait la réunion pour sanctionner un joueur
    public void applySanction(Long playerId, Long eliminationPeriod, String description) {
        Sanction sanction = findSanctionByPlayerId(playerId);
        if (sanction.getNumberOfRedCard() == 1) {
            sanction.setEliminationPeriod(eliminationPeriod);
            sanction.setDescription(description);
            sanction.setExecuted(true);
            sanction.setBeginDate(new Date());
            sanctionRepository.save(sanction);
        }
    }

    private Sanction findSanctionByPlayerId(Long playerId) {
        Sanction sanction;
        List<Sanction> sanctions = sanctionRepository.findByPlayerIdAndExecuted(playerId, false);
        if (!sanctions.isEmpty()) {
            sanction = sanctions.get(0);
        } else {
            sanction = new Sanction(playerId);
        }
        return sanction;
    }

    public List<PlayerCommissionRespons> getAllPlayerWithCards() {
        return this.playerCommissionRepository.getAllPlayerWithCards();
    }


}
