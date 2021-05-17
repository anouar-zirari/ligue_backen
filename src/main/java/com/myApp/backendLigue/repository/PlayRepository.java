package com.myApp.backendLigue.repository;

import com.myApp.backendLigue.entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {
}
