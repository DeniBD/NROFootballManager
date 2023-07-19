package com.nro.footballmanager.mapper;

import com.nro.footballmanager.dto.GameDTO;
import com.nro.footballmanager.entity.Game;
import org.mapstruct.Mapper;

@Mapper
public interface GameMapper {
    GameDTO map(Game game);
    Game map(GameDTO gameDTO);
}
