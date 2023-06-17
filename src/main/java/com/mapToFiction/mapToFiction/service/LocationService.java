package com.mapToFiction.mapToFiction.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mapToFiction.mapToFiction.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface LocationService {
    Location create(Location location);

    Location findByAddress(String address);
    Location findByPlaceId(String placeId);

}
