package com.myApp.backendLigue.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
public class Play {

    // add id to play class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playId;


    @Column(name = "number_red_card")
    private int numberRedCard;
    @Column(name = "number_yalow_card")
    private int numberYalowCard;
    @Column(name = "elimination_period")
    private int eliminationPeriod;
    @Column(name = "game_id")
    private int gameId;
    @Column(name = "player_id")
    private int playerId;

}
