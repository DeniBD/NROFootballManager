package com.nro.footballmanager.repository;

import com.nro.footballmanager.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByTeamOneIdOrTeamTwoId(Long teamOneId, Long teamTwoId);
}
