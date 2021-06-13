package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.dto.PlayerResponse;
import com.myApp.backendLigue.dto.PlayerWithReportResponse;
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

    public List<PlayerWithReportResponse> getPlayerWithReportForRound(Long roundId){
        String query = "\n" +
                "select P.player_id as playerId, P.player_shirt_number as playerShirtNumber,P.player_first_name as playerFirstName, P.player_last_name as playerLastName, R.report_txt as reportTxt\n" +
                "from report R inner join game G on R.game_id = G.game_id inner join rounds D on D.round_id = G.round_id\n" +
                "inner join player P on R.player_id = P.player_id \n" +
                "where D.round_id = " + roundId;
        List<PlayerWithReportResponse> playerWithReportResponses = this.jdbcTemplate.query( query,
                (rs, rowNum) -> new PlayerWithReportResponse(rs.getLong("playerId"),
                        rs.getInt("playerShirtNumber"), rs.getString("playerFirstName"),
                        rs.getString("playerLastName"), rs.getString("reportTxt"))
        );

        return playerWithReportResponses;
    }



}
