package com.myApp.backendLigue.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "league", name = "sanction")
public class Sanction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sanction_id")
    private Long id;
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "number_of_red_card")
    private Integer numberOfRedCard;
    @Column(name = "number_of_yellow_card")
    private Integer numberOfYellowCard;
    @Column(name = "executed")
    private Boolean executed;
    @Column(name = "description")
    private String description;
    @Column(name = "elimination_period")
    private Long eliminationPeriod;
    @Column(name = "begin_date")
    private Date beginDate;


    public Sanction(Long playerId) {
        this.playerId = playerId;
        this.numberOfYellowCard = 0;
        this.numberOfRedCard = 0;
        this.executed = false;
    }

    public Sanction(Long playerId, int card, String redOrYellowCard) {
        this.playerId = playerId;
        if (redOrYellowCard.equals("yellow")) {
            this.numberOfYellowCard = card;
        } else {
            this.numberOfRedCard = card;
        }
    }
}
