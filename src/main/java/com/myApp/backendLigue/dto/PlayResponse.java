package com.myApp.backendLigue.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayResponse {

    private int shirtNumber;
    private String firstName;
    private String lastName;
    private int numberYellowCard;
    private int numberRedCard;
    private String clubName;
    // number of match
    //private int panishmentPeriod;

}
