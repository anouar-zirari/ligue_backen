package com.myApp.backendLigue.repository;

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

}
