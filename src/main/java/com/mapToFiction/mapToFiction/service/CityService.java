package com.mapToFiction.mapToFiction.service;

import com.mapToFiction.mapToFiction.model.City;
import com.mapToFiction.mapToFiction.model.dto.gmaps.ResultsDTO;
import org.springframework.http.ResponseEntity;

public interface CityService {
    ResponseEntity<Void> add(String city);
}
