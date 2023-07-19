package com.nro.footballmanager.mapper;

import com.nro.footballmanager.dto.GameDTO;
import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.dto.TeamDTO;
import com.nro.footballmanager.entity.Game;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TeamMapper {

    public TeamDTO map(Team team);
    public Team map(TeamDTO teamDTO);
}
