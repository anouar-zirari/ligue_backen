package com.myApp.backendLigue.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@Entity

public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int shirtNumber;


    public Player(String firstName, String lastName, int i) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.shirtNumber = i;
    }
}
