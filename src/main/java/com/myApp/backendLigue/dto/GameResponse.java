package com.myApp.backendLigue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameResponse {

    private String hostName;
    private String hostLogo;
    private String visitorName;
    private String visitorLogo;
    private Date gameDate;
}
