package com.myApp.backendLigue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerWithRedCard {
    private Long playerId;
    private Long playId;
    private int playerShirtNumber;
    private String playerFirstName;
    private String playerLastName;
    private int numberRedCard;


}
