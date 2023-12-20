package com.fiktionmaps.fiktionmaps.service;

import com.fiktionmaps.fiktionmaps.model.Fiction;
import com.fiktionmaps.fiktionmaps.service.dto.CityDTO;
import com.fiktionmaps.fiktionmaps.service.dto.FictionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FictionService {

    FictionDTO create(FictionDTO fictionDto);

    FictionDTO update(Long id, FictionDTO fictionDto);

    void delete(Long id);

    List<FictionDTO> getAll();

    List<FictionDTO> getFictionsByCity(Long cityId);

    Fiction findById(Long id);

}
