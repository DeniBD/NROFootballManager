package com.nro.footballmanager.service.impl;

import com.nro.footballmanager.dto.ResultDTO;
import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.Result;
import com.nro.footballmanager.exception.ResourceNotFoundException;
import com.nro.footballmanager.mapper.ResultMapper;
import com.nro.footballmanager.repository.ResultRepository;
import com.nro.footballmanager.service.ResultService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper = Mappers.getMapper(ResultMapper.class);

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public ResultDTO saveResult(ResultDTO resultDTO) {
        Result result = resultRepository.save(resultMapper.map(resultDTO));
        return resultMapper.map(result);
    }

    @Override
    public List<ResultDTO> fetchResultList() {
        List<Result> results = resultRepository.findAll();
        if(results.isEmpty()) {
            throw new ResourceNotFoundException("No results found!");
        }
        return results.stream().map(resultMapper::map).collect(Collectors.toList());
    }

    @Override
    public ResultDTO getResultById(Long id) {
        return resultRepository.findById(id)
                .map(resultMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find result " + id));
    }

    @Override
    public ResultDTO updateResult(ResultDTO resultDTO) {
        resultRepository.findById(resultDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Could not find result " + resultDTO.getId()));
        return resultMapper.map(resultRepository.save(resultMapper.map(resultDTO)));
    }

    @Override
    public void deleteResultById(Long id) {
        resultRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find result " + id));
        resultRepository.deleteById(id);
    }
}
