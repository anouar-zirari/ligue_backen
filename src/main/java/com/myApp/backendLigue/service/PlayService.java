package com.myApp.backendLigue.service;


import com.myApp.backendLigue.dto.PlayResponse;
import com.myApp.backendLigue.entity.Play;
import com.myApp.backendLigue.entity.Sanction;
import com.myApp.backendLigue.repository.PlayPlaningRepository;
import com.myApp.backendLigue.repository.PlayRepository;
import com.myApp.backendLigue.repository.SanctionRepository;
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
    @Autowired
    private SanctionRepository sanctionRepository;


    // the new one (code)
    public void addYellowCard(Long gameId, Long playerId, int numberOfYellowCard) throws Exception {
        List<Play> plays = this.playRepository.findByGameIdAndPlayerId(gameId, playerId);
        Play play;
        int allYellowCardsInDifferentGame = this.findInSanctionByPlayerId(playerId).getNumberOfYellowCard();
        if (plays.isEmpty() && allYellowCardsInDifferentGame < 4) {
            play = new Play(gameId, playerId, numberOfYellowCard, "yellow");
            play.setNumberYalowCard(numberOfYellowCard);
            this.playRepository.save(play);
            this.addYellowCardToSanction(playerId, numberOfYellowCard);
        } else if (allYellowCardsInDifferentGame == 4) {
            throw new Exception("This Player Has 4 Yellow Card In Defferent Game");
        } else {
            play = plays.get(0);
            int numberOfYellowCardAlreadyGiven = play.getNumberYalowCard();
            int numberOfRedCardAlreadyGiven = play.getNumberRedCard();
            if (numberOfYellowCardAlreadyGiven > 1) {
                throw new Exception("This Player Has " + numberOfYellowCardAlreadyGiven + " Yellow Cards");
            }
            if (numberOfRedCardAlreadyGiven > 0) {
                throw new Exception("This Player Has " + numberOfRedCardAlreadyGiven + " Red Card");
            }
            play.setNumberYalowCard(numberOfYellowCardAlreadyGiven + numberOfYellowCard);
            this.addYellowCardToSanction(playerId, numberOfYellowCard);
            this.playRepository.save(play);
        }
    }

    public void addYellowCardToSanction(Long playerId, int yellowCard) throws Exception {
        Sanction sanction = this.findInSanctionByPlayerId(playerId);
        if (sanction == null) {
            sanction = new Sanction(playerId, yellowCard);
            this.sanctionRepository.save(sanction);
        } else {
            int allYellowCardAlreadyGiven = sanction.getNumberOfYellowCard();
            if (allYellowCardAlreadyGiven < 4) {
                sanction.setNumberOfYellowCard(allYellowCardAlreadyGiven + yellowCard);
                this.sanctionRepository.save(sanction);
            } else {
                throw new Exception("this player has " + allYellowCardAlreadyGiven + "already given");
            }
        }
    }

    public Sanction findInSanctionByPlayerId(Long playerId) {
        List<Sanction> sanctions = this.sanctionRepository.findByPlayerId(playerId);
        if (sanctions.isEmpty()) {
            return null;
        } else {
            Sanction sanction = sanctions.get(0);
            return sanction;
        }
    }

    //the old one (code)
    public void addYellowOrRedCard(Long gameId, Long playerId, int numberOfRedCard, int numberOfYellowCard) throws Exception {
        List<Play> plays = this.playRepository.findByGameIdAndPlayerId((long) gameId, (long) playerId);
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
                //System.out.println("Le joueur a déjà un carton rouge");
                throw new Exception("exception in this ");
            } else if (numberOfYellowCardAlreadyGiven > 1 && numberOfRedCardAlreadyGiven > 0) {
                // System.out.println("Le joueur a déjà " + numberOfYellowCardAlreadyGiven + " cartons jaunes" );
                throw new Exception("the player has" + numberOfYellowCardAlreadyGiven);
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
        Long playerId = play.getPlayerId();
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
        } else if (yellowOrRed.equals("red") && numberRedCardGiven > 0) {
            play.setNumberRedCard(numberRedCardGiven - 1);
            this.playRepository.save(play);
            int redCardUpdated = play.getNumberRedCard();
            if (redCardUpdated == 0 && numberYellowCardGiven == 0) {
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
