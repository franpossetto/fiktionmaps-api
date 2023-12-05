package com.fiktionmaps.fiktionmaps.service;

import com.fiktionmaps.fiktionmaps.service.dto.PlaceDTO;

import java.util.List;

public interface PlaceService {
    PlaceDTO create(PlaceDTO cityDTO);

    PlaceDTO update(Long id, PlaceDTO cityDTO);

    void delete(Long id);

    PlaceDTO getById(Long id);

    List<PlaceDTO> getAll();
}
