package com.myApp.backendLigue.entity;

import javax.persistence.*;

@Entity
@Table(schema = "league", name = "round")
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round_id")
    private Long id;
}
