package com.myApp.backendLigue.service;


import com.myApp.backendLigue.dto.PlayResponse;
import com.myApp.backendLigue.entity.Play;
import com.myApp.backendLigue.repository.PlayPlaningRepository;
import com.myApp.backendLigue.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayService {

    // checking yellow card value
    private boolean check = false;
    private Long playRedId;
    private Long playYellowId;
    private int yellowNumber = 0;


    @Autowired
    private PlayRepository playRepository;

    @Autowired
    private PlayPlaningRepository playPlaningRepository;
    @Autowired
    private SanctionService sanctionService;


    public void addYellowOrRedCard(int gameId, int playerId, int numberOfRedCard, int numberOfYellowCard) {
        List<Play> plays = this.playRepository.findByGameIdAndPlayerId(gameId, playerId);
        Play play;
        if (plays.isEmpty()) {
            play = new Play(gameId, playerId, numberOfRedCard, numberOfYellowCard);
            sanctionService.addYellowOrRedCardsToSanction(Long.valueOf(playerId), numberOfRedCard, numberOfYellowCard);
            playRepository.save(play);
        } else {
            play = plays.get(0);
            int numberOfRedCardAlreadyGiven = play.getNumberRedCard();
            int numberOfYellowCardAlreadyGiven = play.getNumberYalowCard();
            if (numberOfRedCardAlreadyGiven > 0) {
                System.out.println("Le joueur a déjà un carton rouge");
            } else if (numberOfYellowCardAlreadyGiven > 1 && numberOfRedCardAlreadyGiven > 0) {
                System.out.println("Le joueur a déjà " + numberOfYellowCardAlreadyGiven + " cartons jaunes" );

            } else {
                // le joueur à un seul carton jaune
                System.out.println("le joueur à un seul carton jaune");
                if (numberOfRedCard == 0 && numberOfYellowCard == 1) {
                    play.setNumberYalowCard(2);
                    //play.setNumberRedCard(1);
                } else {
                    play.setNumberRedCard(1);
                }
                playRepository.save(play);
                sanctionService.addYellowOrRedCardsToSanction(Long.valueOf(playerId), numberOfRedCard, numberOfYellowCard);
            }
        }
    }

    public void removeYellowOrRedCard(Long playId, String yellowOrRed) {
        Play play = this.playRepository.getOne(playId);
        int numberRedCardGiven = play.getNumberRedCard();
        int numberYellowCardGiven = play.getNumberYalowCard();
        int playerId = play.getPlayerId();
        // delete a yellow card work
        if (yellowOrRed.equals("yellow") && numberYellowCardGiven > 0) {
            int newYellowCard = numberYellowCardGiven - 1;
            play.setNumberYalowCard(newYellowCard);
            int yellowCardUpdated = play.getNumberYalowCard();
            if (yellowCardUpdated > 0 || numberRedCardGiven > 0) {
                this.playRepository.save(play);
                this.sanctionService.
                        removeYellowOrRedCardToSanction
                                ((long) playerId, "yellow", numberRedCardGiven, yellowCardUpdated);
            } else if (yellowCardUpdated == 0 && numberRedCardGiven == 0) {
                this.playRepository.delete(play);
                this.sanctionService.
                        removeYellowOrRedCardToSanction
                                ((long) playerId, "yellow", 0, 0);
            }
        }else if(yellowOrRed.equals("red") && numberRedCardGiven > 0){
            play.setNumberRedCard(numberRedCardGiven - 1);
            this.playRepository.save(play);
            int redCardUpdated = play.getNumberRedCard();
            if(redCardUpdated == 0 && numberYellowCardGiven == 0){
                this.playRepository.delete(play);
            }
            this.sanctionService.removeYellowOrRedCardToSanction
                    ((long) playerId, "red", numberRedCardGiven, numberYellowCardGiven);

        }
    }


    // return all player with red and yellow card number
    public List<PlayResponse> getPlayInfo() {
        return this.playPlaningRepository.getPlayInfo();
    }


    // find play by id
    public Optional<Play> findById(Long id) {
        return this.playRepository.findById(id);
    }

}
