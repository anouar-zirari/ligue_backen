package com.myApp.backendLigue.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerWithYellowCard {
    private Long plaeyrId;
    private Long playId;
    private int playerShirtNumber;
    private String playerFirstName;
    private String playerLastName;
    private int numberYellowCards;

}
