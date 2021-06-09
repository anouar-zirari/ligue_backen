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
                "select P.player_id as playerId, P.club_id as clubId, C.club_name as clubName,\n" +
                "P.player_shirt_number as playerShirtNumber,P.player_first_name as playerFirstName, \n" +
                "P.player_last_name as playerLastName ,S.number_of_yellow_card as numberYellowCard,\n" +
                "S.number_of_red_card as numberRedCard ,G.game_date as gameDate, R.report_txt as reportTxt, Rd.round_id as roundId\n" +
                "from sanction S inner join player P inner join club C inner join game G inner join report R inner join rounds Rd\n" +
                "on S.player_id = P.player_id and P.club_id = C.club_id \n" +
                "and G.host_team_id = C.club_id and R.player_id = P.player_id and Rd.round_id = G.round_id;\n";

        List<PlayerCommissionRespons> playerCommissionRespons = this.jdbcTemplate.query(query,
                (rs, rowNum) -> new PlayerCommissionRespons(rs.getLong("playerId"),
                        rs.getLong("clubId"), rs.getString("clubName"),rs.getInt("playerShirtNumber"),
                        rs.getString("playerFirstName"), rs.getString("playerLastName"),
                        rs.getInt("numberYellowCard"), rs.getInt("numberRedCard"),
                        rs.getDate("gameDate"), rs.getString("reportTxt"),
                        rs.getLong("roundId")));

        return playerCommissionRespons;
    }
}
