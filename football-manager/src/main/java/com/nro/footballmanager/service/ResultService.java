package com.nro.footballmanager.service;

import com.nro.footballmanager.dto.PlayerDTO;
import com.nro.footballmanager.dto.ResultDTO;

import java.util.List;

public interface ResultService {
    ResultDTO saveResult(ResultDTO resultDTO);

    List<ResultDTO> fetchResultList();

    ResultDTO getResultById (Long id);

    ResultDTO updateResult(ResultDTO resultDTO);

    void deleteResultById(Long id);
}
