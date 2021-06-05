package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.entity.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanctionRepository extends JpaRepository<Sanction, Long> {

    List<Sanction> findByPlayerIdAndExecuted(Long playerId, Boolean executed);
}
