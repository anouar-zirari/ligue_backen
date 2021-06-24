package com.myApp.backendLigue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerWithReport {
    // reportId
    private Long id;
    private Long playerId;
    private Long gameId;
    private int playerShirtNumber;
    private String playerFirstName;
    private String playerLastName;
    private String reportTxt;

}
