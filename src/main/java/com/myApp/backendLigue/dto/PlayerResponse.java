package com.myApp.backendLigue.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerResponse {
    private Long playerId;
    private String playerFirstName;
    private String PlayerLastName;
    private int playerShirtNumber;


}
