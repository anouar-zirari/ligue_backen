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
public class PlayRefereeResponse {
    private Long playerId;
    private Long refereeId;
    private Long gameId;
    private int shirtNumber;
    private String firstName;
    private String lastName;
    private int numberYellowCard;
    private int  numberRedCard;
    private Date gameDate;

}
