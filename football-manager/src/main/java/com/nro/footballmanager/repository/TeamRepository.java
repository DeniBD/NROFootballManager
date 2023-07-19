package com.nro.footballmanager.repository;

import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByName(String name);
}
