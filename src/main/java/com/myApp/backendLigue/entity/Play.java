package com.myApp.backendLigue.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@NoArgsConstructor
public class Play {

    public Play(Long gameId, Long playerId, int numberRedCard, int numberYalowCard) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.numberRedCard = numberRedCard;
        this.numberYalowCard = numberYalowCard;
    }
    // for add a yellow card
    public Play(Long gameId, Long playerId, int numberYalowOrRedCard, String yellowOrRed){
        this.gameId = gameId;
        this.playerId = playerId;
        if(yellowOrRed.equals("red")){
            this.numberRedCard = numberYalowOrRedCard;
        }
        if(yellowOrRed.equals("yellow")){
            this.numberYalowCard = numberYalowOrRedCard;
        }

    }

    // add id to play class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "play_id")
    private Long playId;
    @Column(name = "game_id")
    private Long gameId;
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "number_red_card")
    private int numberRedCard;
    @Column(name = "number_yalow_card")
    private int numberYalowCard;


}
