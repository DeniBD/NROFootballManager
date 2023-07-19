package com.nro.footballmanager.repository;

import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Long> {

    List<Player> findByTeam(Team team);
}
