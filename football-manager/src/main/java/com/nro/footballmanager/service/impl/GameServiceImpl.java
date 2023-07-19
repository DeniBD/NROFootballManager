package com.nro.footballmanager.service.impl;

import com.nro.footballmanager.dto.GameDTO;
import com.nro.footballmanager.entity.Game;
import com.nro.footballmanager.exception.ResourceNotFoundException;
import com.nro.footballmanager.mapper.GameMapper;
import com.nro.footballmanager.repository.GameRepository;
import com.nro.footballmanager.repository.ResultRepository;
import com.nro.footballmanager.repository.StadiumRepository;
import com.nro.footballmanager.repository.TeamRepository;
import com.nro.footballmanager.service.GameService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ResultRepository resultRepository;
    private final StadiumRepository stadiumRepository;
    private final TeamRepository teamRepository;
    private final GameMapper gameMapper = Mappers.getMapper(GameMapper.class);

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ResultRepository resultRepository, StadiumRepository stadiumRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.resultRepository = resultRepository;
        this.stadiumRepository = stadiumRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public GameDTO saveGame(GameDTO gameDTO) {
        Game game = gameRepository.save(gameMapper.map(gameDTO));
        return gameMapper.map(game);
    }

    @Override
    public List<GameDTO> fetchGameList() {
        List<Game> games = gameRepository.findAll();
        if(games.isEmpty()) {
            throw new ResourceNotFoundException("No games found!");
        }
        return games.stream().map(gameMapper::map).collect(Collectors.toList());
    }

    @Override
    public GameDTO getGameById(Long id) {
        return gameRepository.findById(id)
                .map(gameMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find game " + id));
    }

    @Override
    public GameDTO updateGame(GameDTO gameDTO) {
        gameRepository.findById(gameDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Could not find game " + gameDTO.getId()));
        resultRepository.findById(gameDTO.getResult().getId()).orElseThrow(() -> new ResourceNotFoundException("Could not find result " + gameDTO.getResult().getId()));
        stadiumRepository.findById(gameDTO.getStadium().getId()).orElseThrow(() -> new ResourceNotFoundException("Could not find stadium " + gameDTO.getStadium()));
        teamRepository.findById(gameDTO.getTeamOne().getId()).orElseThrow(() -> new ResourceNotFoundException("Could not find teamOne " + gameDTO.getTeamOne().getId()));
        teamRepository.findById(gameDTO.getTeamTwo().getId()).orElseThrow(() -> new ResourceNotFoundException("Could not find teamTwo " + gameDTO.getTeamOne().getId()));
        return gameMapper.map(gameRepository.save(gameMapper.map(gameDTO)));
    }

    @Override
    public void deleteGameById(Long id) {
        gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find game " + id));
        gameRepository.deleteById(id);

    }
}
