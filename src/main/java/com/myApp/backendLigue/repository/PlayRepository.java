package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {

    List<Play> findByGameIdAndPlayerId(int gameId, int playerId);
}
