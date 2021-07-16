package com.myApp.backendLigue.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerCommissionRespons {
    private String clubName;
    private int playerShirtNumber;
    private String playerFirstName;
    private String playerLastName;
    private int numberYellowCard;
    private int numberRedCard;
    private int eliminationPeriod;

}
