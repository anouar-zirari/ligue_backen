package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.dto.GameResponse;
import com.myApp.backendLigue.entity.Game;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(value = "SELECT * FROM game WHERE round_id = ?", nativeQuery = true)
    public List<Game> findByRoundId(Long id);

    @Query(value = "SELECT HOST.CLUB_NAME as hostName, HOST.CLUB_LOGO as hostLogo , VISITOR.CLUB_NAME as visitorName, VISITOR.CLUB_LOGO as visitorLogo" +
            " FROM ROUNDS R INNER JOIN GAME G INNER JOIN CLUB HOST" +
            " INNER JOIN CLUB VISITOR ON R.ROUND_ID = G.ROUND_ID " +
            "AND G.HOST_TEAM_ID = HOST.CLUB_ID AND G.VISITOR_TEAM_ID = VISITOR.CLUB_ID " +
            "WHERE R.ROUND_ID = 1;", nativeQuery = true)
    public List<GameResponse> findClubs(Long id);




}
