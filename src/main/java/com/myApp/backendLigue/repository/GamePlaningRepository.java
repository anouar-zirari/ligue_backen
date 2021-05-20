package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.dto.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamePlaningRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<GameResponse> getGamesForRound(Long roundId) {

        String query = "SELECT HOST.CLUB_NAME as hostName, HOST.CLUB_LOGO as hostLogo , VISITOR.CLUB_NAME as visitorName, VISITOR.CLUB_LOGO as visitorLogo," +
                "G.game_date as gameDate" +
                "FROM ROUNDS R INNER JOIN GAME G INNER JOIN CLUB HOST" +
                " INNER JOIN CLUB VISITOR ON R.ROUND_ID = G.ROUND_ID " +
                "AND G.HOST_TEAM_ID = HOST.CLUB_ID AND G.VISITOR_TEAM_ID = VISITOR.CLUB_ID" +
                "WHERE R.ROUND_ID =  " + roundId;
        List<GameResponse> gameResponses = jdbcTemplate.query(query,
                (rs, rowNum) -> new GameResponse(rs.getString("hostName"), rs.getString("hostLogo"),
                        rs.getString("visitorName"), rs.getString("visitorLogo"), rs.getDate("gameDate")));

        return gameResponses;
    }
}
