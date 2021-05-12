package com.myApp.backendLigue.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
public class Play {
    @Column(name = "number_red_card")
    private int numberRedCard;
    @Column(name = "number_yalow_card")
    private int number_yalow_card;
    @Column(name = "game_id")
    private int gameId;
    @Column(name = "player_id")
    private int playerId;

}
