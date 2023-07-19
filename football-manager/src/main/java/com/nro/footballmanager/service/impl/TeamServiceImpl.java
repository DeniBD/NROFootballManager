package com.nro.footballmanager.service.impl;

import com.nro.footballmanager.dto.TeamDTO;
import com.nro.footballmanager.entity.Game;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.Team;
import com.nro.footballmanager.exception.ResourceNotFoundException;
import com.nro.footballmanager.mapper.TeamMapper;
import com.nro.footballmanager.repository.GameRepository;
import com.nro.footballmanager.repository.PlayerRepository;
import com.nro.footballmanager.repository.TeamRepository;
import com.nro.footballmanager.service.TeamService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl  implements TeamService {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    private final TeamMapper teamMapper = Mappers.getMapper(TeamMapper.class);

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository, GameRepository gameRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public TeamDTO saveTeam(TeamDTO teamDTO) {
        Team team = teamRepository.save(teamMapper.map(teamDTO));
        return teamMapper.map(team);
    }

    @Override
    public List<TeamDTO> fetchTeamList() {
        List<Team> teams = teamRepository.findAll();
        if(teams.isEmpty()) {
            throw new ResourceNotFoundException("No teams found!");
        }
        return teams.stream().map(teamMapper::map).collect(Collectors.toList());
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        return teamRepository.findById(id)
                .map(teamMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find team " + id));
    }

    @Override
    public TeamDTO getTeamByName(String name) {
        Team team = teamRepository.findByName(name);
        return teamMapper.map(team);
    }



    @Override
    public TeamDTO updateTeam(TeamDTO teamDTO) {
        Team team = teamRepository.findById(teamDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Could not find team " + teamDTO.getId()));
        return teamMapper.map(teamRepository.save(teamMapper.map(teamDTO)));
    }

    @Override
    public void deleteTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find team " + id));
        List<Player> players = playerRepository.findByTeam(team);
        for (Player player : players) {
            player.setTeam(null);
        }
        playerRepository.saveAll(players);

        List<Game> games = gameRepository.findByTeamOneIdOrTeamTwoId(team.getId(), team.getId());
        for (Game game : games) {
            if (game.getTeamOne() != null && game.getTeamOne().equals(id)) {
                game.setTeamOne(null);
            }
            if (game.getTeamTwo() != null && game.getTeamTwo().equals(id)) {
                game.setTeamTwo(null);
            }
        }

        gameRepository.saveAll(games);

        teamRepository.deleteById(id);
    }
}
