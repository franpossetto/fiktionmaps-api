package com.mapToFiction.mapToFiction.service.impl;

import com.mapToFiction.mapToFiction.model.City;
import com.mapToFiction.mapToFiction.repository.CityRepository;
import com.mapToFiction.mapToFiction.repository.FictionRepository;
import com.mapToFiction.mapToFiction.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City updateCity(Long id, City cityUpdate){
        return cityRepository.findById(id)
                .map(city -> {
                    city.setName(cityUpdate.getName());
                    // actualizar otros campos aquí
                    return cityRepository.save(city);
                })
                .orElseThrow(() -> new IllegalArgumentException("City not found with id " + id));
    }

    public ResponseEntity<Void> deleteCity(Long id) {
        cityRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}