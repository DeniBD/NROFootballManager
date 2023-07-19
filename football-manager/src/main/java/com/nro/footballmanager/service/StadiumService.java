package com.nro.footballmanager.service;

import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.dto.StadiumDTO;

import java.util.List;

public interface StadiumService {
    StadiumDTO saveStadium(StadiumDTO stadiumDTO);

    List<StadiumDTO> fetchStadiumList();

    StadiumDTO getStadiumById (Long id);

    StadiumDTO updateStadium(StadiumDTO stadiumDTO);

    void deleteStadiumById(Long id);
}
