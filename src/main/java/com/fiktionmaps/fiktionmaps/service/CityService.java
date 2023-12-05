package com.fiktionmaps.fiktionmaps.service;
import com.fiktionmaps.fiktionmaps.service.dto.CityDTO;

import java.util.List;

public interface CityService {

    CityDTO create(CityDTO cityDTO);

    CityDTO update(Long id, CityDTO cityDTO);

    void delete(Long id);

    CityDTO getById(Long id);

    List<CityDTO> getAll();
}

