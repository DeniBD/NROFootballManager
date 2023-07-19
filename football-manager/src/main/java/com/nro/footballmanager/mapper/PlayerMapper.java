package com.nro.footballmanager.mapper;

import com.nro.footballmanager.dto.GameDTO;
import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.entity.Player;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerMapper {
    PlayerDTO map(Player player);
    Player map(PlayerDTO playerDTO);
}
