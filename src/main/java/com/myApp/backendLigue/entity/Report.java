package com.myApp.backendLigue.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(schema = "league", name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;
    @Column(name = "referee_id")
    private Long refereeId;
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "game_id")
    private Long gameId;
    @Column(name = "report_txt")
    private String reportTxt;

    public Report(Long refereeId, Long playerId, Long gameId) {
        this.refereeId = refereeId;
        this.playerId = playerId;
        this.gameId = gameId;
    }
}
