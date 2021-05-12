package com.myApp.backendLigue.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;
    @Column(name = "club_name")
    private String clubName;
    @Column(name = "club_logo")
    private String clubLogo;

}
