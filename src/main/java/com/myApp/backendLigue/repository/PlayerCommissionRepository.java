package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.dto.PlayerCommissionRespons;
import com.myApp.backendLigue.dto.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerCommissionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PlayerCommissionRespons> getAllPlayerWithCards(){
        String query = "\n" +
                "select C.club_name as clubName, \n" +
                "P.player_shirt_number as playerShirtNumber,\n" +
                "P.player_first_name as playerFirstName,\n" +
                "P.player_last_name as playerLastName,\n" +
                "S.number_of_yellow_card as numberYellowCard,\n" +
                "S.number_of_red_card as numberRedCard,\n" +
                "S.elimination_period as eliminationPeriod\n" +
                "from club C inner join player P inner join sanction S\n" +
                "on C.club_id = P.club_id and P.player_id = S.player_id\n";

        List<PlayerCommissionRespons> playerCommissionRespons = this.jdbcTemplate.query(query,
                (rs, rowNum) -> new PlayerCommissionRespons(
                        rs.getString("clubName"),
                        rs.getInt("playerShirtNumber"),
                        rs.getString("playerFirstName"),
                        rs.getString("playerLastName"),
                        rs.getInt("numberYellowCard"),
                        rs.getInt("numberRedCard"),
                        rs.getInt("eliminationPeriod")
                        )
        );

        return playerCommissionRespons;
    }
}
