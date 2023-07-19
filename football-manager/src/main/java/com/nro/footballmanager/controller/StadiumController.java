package com.nro.footballmanager.controller;

import com.nro.footballmanager.dto.GameDTO;
import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.dto.StadiumDTO;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.Stadium;
import com.nro.footballmanager.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("stadiums")
@CrossOrigin(origins = {"http://localhost:8090", "http://localhost:3000"})
public class StadiumController {
    private final StadiumService stadiumService;

    @Autowired
    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @PostMapping
    public ResponseEntity<Stadium> saveStadium(@RequestBody StadiumDTO stadiumDTO) {
        StadiumDTO savedStadiumDTO = stadiumService.saveStadium(stadiumDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedStadiumDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<StadiumDTO>> fetchStadiumList() {
        List<StadiumDTO> stadiumDTOList = stadiumService.fetchStadiumList();
        return ResponseEntity.ok(stadiumDTOList);
    }

    @GetMapping("{id}")
    public ResponseEntity<StadiumDTO> getStadiumById(@PathVariable("id") Long id) {
        StadiumDTO stadiumDTO = stadiumService.getStadiumById(id);
        return ResponseEntity.ok(stadiumDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<StadiumDTO> updateStadium(@RequestBody StadiumDTO stadiumDTO, @PathVariable("id") Long id) {
        StadiumDTO updatedStadiumDTO = stadiumService.updateStadium(stadiumDTO);
        return ResponseEntity.ok(updatedStadiumDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStadiumById(@PathVariable("id") Long id) {
        stadiumService.deleteStadiumById(id);
        return ResponseEntity.ok().build();
    }
}
