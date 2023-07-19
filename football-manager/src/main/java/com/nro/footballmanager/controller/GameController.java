package com.nro.footballmanager.controller;

import com.nro.footballmanager.dto.GameDTO;
import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.entity.Game;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("games")
@CrossOrigin(origins = {"http://localhost:8090", "http://localhost:3000"})
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody GameDTO gameDTO) {
        GameDTO savedGameDTO = gameService.saveGame(gameDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedGameDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> fetchGameList() {
        List<GameDTO> gameDTOList = gameService.fetchGameList();
        return ResponseEntity.ok(gameDTOList);
    }

    @GetMapping("{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable("id") Long id) {
        GameDTO gameDTO = gameService.getGameById(id);
        return ResponseEntity.ok(gameDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<GameDTO> updateGame(@RequestBody GameDTO gameDTO, @PathVariable("id") Long id) {
        GameDTO updatedGameDTO = gameService.updateGame(gameDTO);
        return ResponseEntity.ok(updatedGameDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGameById(@PathVariable("id") Long id) {
        gameService.deleteGameById(id);
        return ResponseEntity.ok().build();
    }
}
