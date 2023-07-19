package com.nro.footballmanager.mapper;

import com.nro.footballmanager.dto.GameDTO;
import com.nro.footballmanager.dto.ResultDTO;
import com.nro.footballmanager.entity.Game;
import com.nro.footballmanager.entity.Result;
import org.mapstruct.Mapper;

@Mapper
public interface ResultMapper {
    ResultDTO map(Result result);
    Result map(ResultDTO resultDTO);

}
