package com.mapToFiction.mapToFiction.service.impl;

import com.mapToFiction.mapToFiction.mapper.CityMapper;
import com.mapToFiction.mapToFiction.model.City;
import com.mapToFiction.mapToFiction.repository.CityRepository;
import com.mapToFiction.mapToFiction.repository.FictionRepository;
import com.mapToFiction.mapToFiction.service.CityService;
import com.mapToFiction.mapToFiction.service.dto.CityDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<CityDTO> getAll() {
        return cityMapper.toDtoList(cityRepository.findAll());
    }

    @Override
    public CityDTO getCityById(Long id) {
        return cityMapper.toDto(cityRepository.findById(id).get());
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

    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

}
