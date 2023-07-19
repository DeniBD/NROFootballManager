package com.nro.footballmanager.service;

import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.dto.TeamDTO;

import java.util.List;

public interface TeamService {
    TeamDTO saveTeam(TeamDTO teamDTO);

    List<TeamDTO> fetchTeamList();

    TeamDTO getTeamById (Long id);

    TeamDTO getTeamByName(String name);

    TeamDTO updateTeam(TeamDTO teamDTO);

    void deleteTeamById(Long id);
}
