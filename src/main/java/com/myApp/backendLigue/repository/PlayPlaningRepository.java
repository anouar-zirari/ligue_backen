package com.myApp.backendLigue.repository;


import com.myApp.backendLigue.dto.PlayRefereeResponse;
import com.myApp.backendLigue.dto.PlayResponse;
import com.myApp.backendLigue.dto.PlayerOfClubInfo;
import com.myApp.backendLigue.entity.Play;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayPlaningRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // for the commission see all players with red and yellow card
    public List<PlayResponse> getPlayInfo(){
        String query = "\n" +
                "select P.player_shirt_number as shirtNumber, P.player_first_name as firstName, P. player_last_name as lastName, Pl. number_yalow_card as numberYellowCard,\n" +
                "Pl.number_red_card as numberRedCard, C.club_name as clubName from PLAYER P inner join PLAY Pl inner join club C\n" +
                "on P.player_id = Pl.player_id and P.club_id = C.club_id;";
        List<PlayResponse> playResponses = this.jdbcTemplate.query(
                query, (rs, rowNum) -> new PlayResponse(rs.getInt("shirtNumber"),
                        rs.getString("firstName"), rs.getString("lastName"),
                        rs.getInt("numberYellowCard"), rs.getInt("numberRedCard"),
                        rs.getString("clubName"))
        );

        return playResponses;
    }


    //for the referee delete and edit
    public List<PlayRefereeResponse> getPlayersWithCardsInGame(Long gameId, Long refereeId){
        String query = "select P.player_id AS playerId, P.player_shirt_number as shirtNumber, " +
                "P.player_first_name as firstName, P. player_last_name as lastName, Pl. number_yalow_card as numberYellowCard," +
                " Pl.number_red_card as numberRedCard, C.club_name as clubName, " +
                "G.game_id as gameId, G.game_date as gameDate, R.referee_id as refereeId " +
                "from PLAYER P inner join PLAY Pl inner join club C inner join game G inner join referee R " +
                "on P.player_id = Pl.player_id and P.club_id = C.club_id and Pl.game_id = G.game_id and R.referee_id = G.referee_id " +
                "where G.game_id = " + gameId + " and  R.referee_id = " + refereeId;
        List<PlayRefereeResponse> playRefereeResponses = this.jdbcTemplate.query(
                query,(rs, rowNum) -> new PlayRefereeResponse(
                        rs.getLong("playerId"), rs.getLong("refereeId"),
                        rs.getLong("gameId"), rs.getInt("shirtNumber"),
                        rs.getString("firstName"), rs.getString("lastName"),
                        rs.getInt("numberYellowCard"), rs.getInt("numberRedCard"),
                        rs.getDate("gameDate")
                ));

        return playRefereeResponses;

    }




}
