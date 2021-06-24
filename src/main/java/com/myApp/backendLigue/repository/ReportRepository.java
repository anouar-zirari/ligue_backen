package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByRefereeIdAndPlayerIdAndGameId(Long refereeId, Long playerId, Long gameId);
    List<Report> findByGameIdAndPlayerId(Long id, Long gameId);
}
