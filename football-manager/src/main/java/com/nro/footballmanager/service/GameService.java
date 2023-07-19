package com.nro.footballmanager.service;

import com.nro.footballmanager.dto.GameDTO;
import com.nro.footballmanager.dto.PlayerDTO;

import java.util.List;

public interface GameService {
    GameDTO saveGame(GameDTO gameDTO);

    List<GameDTO> fetchGameList();

    GameDTO getGameById (Long id);

    GameDTO updateGame(GameDTO gameDTO);

    void deleteGameById(Long id);
}
