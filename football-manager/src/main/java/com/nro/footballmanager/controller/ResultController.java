package com.nro.footballmanager.controller;

import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.dto.ResultDTO;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.Result;
import com.nro.footballmanager.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("results")
@CrossOrigin(origins = {"http://localhost:8090", "http://localhost:3000"})
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping
    public ResponseEntity<Result> saveResult(@RequestBody ResultDTO resultDTO) {
        ResultDTO savedResultDTO = resultService.saveResult(resultDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedResultDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<ResultDTO>> fetchResultList() {
        List<ResultDTO> resultDTOList = resultService.fetchResultList();
        return ResponseEntity.ok(resultDTOList);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResultDTO> getResultById(@PathVariable("id") Long id) {
        ResultDTO resultDTO = resultService.getResultById(id);
        return ResponseEntity.ok(resultDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResultDTO> updateResult(@RequestBody ResultDTO resultDTO, @PathVariable("id") Long id) {
        ResultDTO updatedResultDTO = resultService.updateResult(resultDTO);
        return ResponseEntity.ok(updatedResultDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteResultById(@PathVariable("id") Long id) {
        resultService.deleteResultById(id);
        return ResponseEntity.ok().build();
    }
}
