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

    public List<PlayerResponse> getPlayerForClub(Long id){
        String query = "\n" +
                "SELECT P.player_id as playerId, P.player_first_name as playerFirstName, P.player_last_name as PlayerLastName, " +
                "P.player_shirt_number as playerShirtNumber FROM PLAYER P INNER JOIN CLUB C ON P.CLUB_ID = C.CLUB_ID WHERE C.CLUB_ID = " + id;

        List<PlayerResponse> playerResponses = this.jdbcTemplate.query(query,
                (rs, rowNum)-> new PlayerResponse(rs.getLong("playerId"), rs.getString("playerFirstName"),
                        rs.getString("PlayerLastName"),rs.getInt("playerShirtNumber")));

        return playerResponses;
    }
}
