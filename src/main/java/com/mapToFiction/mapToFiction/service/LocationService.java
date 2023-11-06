package com.mapToFiction.mapToFiction.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.service.dto.LocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    List<LocationDTO> getAll();
    Location create(Location location);
    Location findByAddress(String address);
    Optional<Location> findByPlaceId(String placeId);

}
