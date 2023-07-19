package com.nro.footballmanager.service.impl;

import com.nro.footballmanager.dto.StadiumDTO;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.Stadium;
import com.nro.footballmanager.exception.ResourceNotFoundException;
import com.nro.footballmanager.mapper.StadiumMapper;
import com.nro.footballmanager.repository.StadiumRepository;
import com.nro.footballmanager.service.StadiumService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper = Mappers.getMapper(StadiumMapper.class);

    @Autowired
    public StadiumServiceImpl(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    public StadiumDTO saveStadium(StadiumDTO stadiumDTO) {
        Stadium stadium = stadiumRepository.save(stadiumMapper.map(stadiumDTO));
        return stadiumMapper.map(stadium);
    }

    @Override
    public List<StadiumDTO> fetchStadiumList() {
        List<Stadium> stadiums = stadiumRepository.findAll();
        if(stadiums.isEmpty()) {
            throw new ResourceNotFoundException("No stadiums found!");
        }
        return stadiums.stream().map(stadiumMapper::map).collect(Collectors.toList());
    }

    @Override
    public StadiumDTO getStadiumById(Long id) {
        return stadiumRepository.findById(id)
                .map(stadiumMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find stadium " + id));
    }

    @Override
    public StadiumDTO updateStadium(StadiumDTO stadiumDTO) {
        stadiumRepository.findById(stadiumDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Could not find stadium " + stadiumDTO.getId()));
        return stadiumMapper.map(stadiumRepository.save(stadiumMapper.map(stadiumDTO)));
    }

    @Override
    public void deleteStadiumById(Long id) {
        stadiumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find stadium " + id));
        stadiumRepository.deleteById(id);
    }
}
