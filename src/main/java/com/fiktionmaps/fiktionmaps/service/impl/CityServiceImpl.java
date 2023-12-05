package com.fiktionmaps.fiktionmaps.service.impl;

import com.fiktionmaps.fiktionmaps.mapper.CityMapper;
import com.fiktionmaps.fiktionmaps.model.City;
import com.fiktionmaps.fiktionmaps.repository.CityRepository;
import com.fiktionmaps.fiktionmaps.service.CityService;
import com.fiktionmaps.fiktionmaps.service.dto.CityDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public CityDTO create(CityDTO cityDTO) {
        City city = cityMapper.toEntity(cityDTO);
        City savedCity = cityRepository.save(city);
        return cityMapper.toDto(savedCity);
    }

    @Override
    public CityDTO update(Long id, CityDTO cityDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CityDTO getById(Long id) {
        return cityMapper.toDto(cityRepository.findById(id).get());
    }

    @Override
    public List<CityDTO> getAll() {
        return cityMapper.toDtoList(cityRepository.findAll());
    }
}
