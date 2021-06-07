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

    public Play(int gameId, int playerId, int numberRedCard, int numberYalowCard) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.numberRedCard = numberRedCard;
        this.numberYalowCard = numberYalowCard;
    }
    // add id to play class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "play_id")
    private Long playId;
    @Column(name = "game_id")
    private int gameId;
    @Column(name = "player_id")
    private int playerId;
    @Column(name = "number_red_card")
    private int numberRedCard;
    @Column(name = "number_yalow_card")
    private int numberYalowCard;


}
