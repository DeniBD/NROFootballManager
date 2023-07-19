package com.nro.footballmanager.controller;

import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.dto.TeamDTO;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.Team;
import com.nro.footballmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("teams")
@CrossOrigin(origins = {"http://localhost:8090", "http://localhost:3000"})
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<Team> saveTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO savedTeamDTO = teamService.saveTeam(teamDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTeamDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> fetchTeamList() {
        List<TeamDTO> teamDTOList = teamService.fetchTeamList();
        Collections.sort(teamDTOList);
        return ResponseEntity.ok(teamDTOList);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<TeamDTO> getTeamByName(@PathVariable("name") String name) {
        TeamDTO teamDTO = teamService.getTeamByName(name);
        return ResponseEntity.ok(teamDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable("id") Long id) {
        TeamDTO teamDTO = teamService.getTeamById(id);
        return ResponseEntity.ok(teamDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeamDTO> updatTeam(@RequestBody TeamDTO teamDTO, @PathVariable("id") Long id) {
        TeamDTO updatedTeamDTO = teamService.updateTeam(teamDTO);
        return ResponseEntity.ok(updatedTeamDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable("id") Long id) {
        teamService.deleteTeamById(id);
        return ResponseEntity.ok().build();
    }
}
