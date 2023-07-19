package com.nro.footballmanager.service.impl;

import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.exception.ResourceNotFoundException;
import com.nro.footballmanager.mapper.PlayerMapper;
import com.nro.footballmanager.mapper.TeamMapper;
import com.nro.footballmanager.repository.PlayerRepository;
import com.nro.footballmanager.repository.TeamRepository;
import com.nro.footballmanager.service.PlayerService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerMapper playerMapper = Mappers.getMapper(PlayerMapper.class);
    private final TeamMapper teamMapper = Mappers.getMapper(TeamMapper.class);

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }


//    @Override
//    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
//        Player player = playerRepository.save(playerMapper.map(playerDTO));
//        return playerMapper.map(player);
//    }

    @Override
    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        PlayerDTO newPlayer = new PlayerDTO(
                playerDTO.getName(),
                playerDTO.getGoalsScored(),
                playerDTO.getRole(),
                teamMapper.map(teamRepository.findByName(playerDTO.getTeam().getName()))
        );
        Player player = playerRepository.save(playerMapper.map(newPlayer));
        return playerMapper.map(player);
    }


    @Override
    public List<PlayerDTO> fetchPlayerList() {
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()) {
            throw new ResourceNotFoundException("No players found!");
        }
        return players.stream().map(playerMapper::map).collect(Collectors.toList());
    }

    @Override
    public PlayerDTO getPlayerById(Long id) {
        return playerRepository.findById(id)
                .map(playerMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find player " + id));
    }

    @Override
    public PlayerDTO updatePlayer(PlayerDTO playerDTO) {
        playerRepository.findById(playerDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Could not find player " + playerDTO.getId()));
        return playerMapper.map(playerRepository.save(playerMapper.map(playerDTO)));
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find player " + id));
        playerRepository.deleteById(id);
    }
}
