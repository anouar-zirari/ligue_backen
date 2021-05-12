package com.myApp.backendLigue.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode
@Entity
@Table(schema = "league", name = "game")

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;
    @Column(name = "game_date")
    private Date gameDate;
    @Column(name = "round_id")
    private Long roundId;
    @Column(name = "host_team_id")
    private Long hostTeamId;
    @Column(name = "visitor_team_id")
    private Long visitorTeamId;




}
