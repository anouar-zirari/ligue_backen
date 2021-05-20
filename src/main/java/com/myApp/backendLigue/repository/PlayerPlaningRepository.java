package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.dto.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerPlaningRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PlayerResponse> getPlayerForClub(String clubName){
        String query = "SELECT P.player_first_name, P.player_last_name, P.player_shirt_number\n" +
                ",C.CLUB_NAME\n" +
                "FROM PLAYER P INNER JOIN CLUB C ON P.CLUB_ID = C.CLUB_ID\n" +
                "WHERE C.CLUB_Name = " + clubName;

        List<PlayerResponse> playerResponses = this.jdbcTemplate.query(query,
                (rs, rowNum)-> new PlayerResponse(rs.getString("playerFirstName"),
                        rs.getString("PlayerLastName"),rs.getInt("playerShirtNumber"),
                        rs.getString("clubName")));

        return playerResponses;
    }
}
