package com.mapToFiction.mapToFiction.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mapToFiction.mapToFiction.model.City;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CityService {
    City create(City city);

    List<City> getAll();

    City updateCity(Long id, City city);

    ResponseEntity<Void> deleteCity(Long id);

    Optional<City> findById(Long id);

}
