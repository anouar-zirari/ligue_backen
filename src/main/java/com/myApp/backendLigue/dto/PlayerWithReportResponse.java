package com.myApp.backendLigue.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerWithReportResponse {

    private Long playerId;
    private int playerShirtNumber;
    private String playerFirstName;
    private String playerLastName;
    private String reportTxt;

}
