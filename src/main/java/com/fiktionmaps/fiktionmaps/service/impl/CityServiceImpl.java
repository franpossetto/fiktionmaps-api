package com.fiktionmaps.fiktionmaps.service.impl;

import com.fiktionmaps.fiktionmaps.mapper.CityMapper;
import com.fiktionmaps.fiktionmaps.model.City;
import com.fiktionmaps.fiktionmaps.repository.CityRepository;
import com.fiktionmaps.fiktionmaps.service.CityService;
import com.fiktionmaps.fiktionmaps.service.dto.CityDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Optional<City> cityOptional = cityRepository.findById(id);
        return cityOptional.map(cityMapper::toDto).orElse(null);
    }

    @Override
    public List<CityDTO> getAll() {
        List<CityDTO> cityDTOs = cityMapper.toDtoList(cityRepository.findAll());
        List<Object[]> amountOfPlaces = cityRepository.countPlacesInCities();

        Map<Long, Long> placesCountMap = amountOfPlaces.stream()
                .collect(Collectors.toMap(
                        record -> (Long) record[0],
                        record -> (Long) record[1]
                ));

        cityDTOs.forEach(cityDTO -> {
            Long count = placesCountMap.getOrDefault(cityDTO.getId(), 0L);
            cityDTO.setAmountOfPlaces(count);
        });

        return cityDTOs;
    }

}
