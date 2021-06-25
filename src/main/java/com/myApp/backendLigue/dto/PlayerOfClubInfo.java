package com.myApp.backendLigue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerOfClubInfo {
    private Long playerId;
    private Long clubId;
    private Long sanctionId;
    private int playerShirtNumber;
    private String playerFirstName;
    private String playerLastName;
    private String clubName;
    private String clubLogo;
    private int numberYellowCard;
    private int numberRedCard;
    private int eliminationPeriod;
    private String description;
}
