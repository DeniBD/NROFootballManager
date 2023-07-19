package com.nro.footballmanager.controller;

import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("players")
@CrossOrigin(origins = {"http://localhost:8090", "http://localhost:3000"})
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO savedPlayerDTO = playerService.savePlayer(playerDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPlayerDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> fetchPlayerList() {
        List<PlayerDTO> playerListDTO = playerService.fetchPlayerList();
        Collections.sort(playerListDTO);
        return ResponseEntity.ok(playerListDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable("id") Long id) {
        PlayerDTO playerDTO = playerService.getPlayerById(id);
        return ResponseEntity.ok(playerDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO updatedPlayerDTO = playerService.updatePlayer(playerDTO);
        return ResponseEntity.ok(updatedPlayerDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable("id") Long id) {
        playerService.deletePlayerById(id);
        return ResponseEntity.ok().build();
    }
}
