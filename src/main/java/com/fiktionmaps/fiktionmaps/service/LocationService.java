package com.fiktionmaps.fiktionmaps.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fiktionmaps.fiktionmaps.service.dto.LocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    List<LocationDTO> getAll();
    LocationDTO create(LocationDTO locationDto);
    LocationDTO findByAddress(String address);
    Optional<LocationDTO> findByPlaceId(String placeId);
}
