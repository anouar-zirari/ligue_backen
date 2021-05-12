package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepo extends JpaRepository<Club, Long> {
}
