package com.fiktionmaps.fiktionmaps.service;

import com.fiktionmaps.fiktionmaps.service.dto.CityDTO;
import com.fiktionmaps.fiktionmaps.service.dto.FictionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FictionService {

    FictionDTO create(FictionDTO fictionDto);

    FictionDTO update(Long id, FictionDTO fictionDto);

    void delete(Long id);

    ResponseEntity<List<FictionDTO>> getAll();

    ResponseEntity<List<FictionDTO>> getFictionsByCity(Long cityId);

}
