package com.myApp.backendLigue.entity;

import javax.persistence.*;

@Entity
@Table(schema = "league", name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;
    @Column(name = "player_first_name")
    private String playerFirstName;
    @Column(name = "player_last_name")
    private String playerLastName;
    @Column(name = "player_shirt_number")
    private int player_shirt_number;
    @Column(name = "club_id")
    private Long club_id;




}
