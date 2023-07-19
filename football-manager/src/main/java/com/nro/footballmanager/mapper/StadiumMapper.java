package com.nro.footballmanager.mapper;

import com.nro.footballmanager.dto.GameDTO;
import com.nro.footballmanager.dto.StadiumDTO;
import com.nro.footballmanager.entity.Game;
import com.nro.footballmanager.entity.Stadium;
import org.mapstruct.Mapper;

@Mapper
public interface StadiumMapper {
    StadiumDTO map(Stadium stadium);
    Stadium map(StadiumDTO stadiumDTO);
}
