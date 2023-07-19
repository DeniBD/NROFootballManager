package com.nro.footballmanager.service;

import com.nro.footballmanager.dto.PlayerDTO;


import java.util.List;

public interface PlayerService {

    PlayerDTO savePlayer(PlayerDTO playerDTO);

    List<PlayerDTO> fetchPlayerList();

    PlayerDTO getPlayerById (Long id);

    PlayerDTO updatePlayer(PlayerDTO playerDTO);

    void deletePlayerById(Long id);
}
