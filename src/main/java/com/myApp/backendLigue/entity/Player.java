package com.myApp.backendLigue.entity;

import javax.persistence.*;

@Entity
@Table(schema = "league", name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;


}
