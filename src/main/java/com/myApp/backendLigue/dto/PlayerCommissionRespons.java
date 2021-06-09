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
    private Long playerId;
    private Long clubId;
    private String clubName;
    private int playerShirtNumber;
    private String playerFirstName;
    private String playerLastName;
    private int numberYellowCard;
    private int numberRedCard;
    private Date gameDate;
    private String reportTxt;
    private Long roundId;
}
