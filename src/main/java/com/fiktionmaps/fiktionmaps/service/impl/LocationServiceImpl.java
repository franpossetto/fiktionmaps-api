package com.fiktionmaps.fiktionmaps.service.impl;

import com.fiktionmaps.fiktionmaps.mapper.LocationMapper;
import com.fiktionmaps.fiktionmaps.model.Location;
import com.fiktionmaps.fiktionmaps.repository.LocationRepository;
import com.fiktionmaps.fiktionmaps.service.LocationService;
import com.fiktionmaps.fiktionmaps.service.dto.LocationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    public final LocationRepository locationRepository;
    public final LocationMapper locationMapper;
    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper){
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public List<LocationDTO> getAll() {
        return locationMapper.toDtoList(locationRepository.findAll());
    }

    @Override
    public LocationDTO create(LocationDTO locationDto) {
        Location location = locationMapper.toEntity(locationDto);
        return locationMapper.toDto(locationRepository.save(location));
    }

    @Override
    public LocationDTO findByAddress(String address) {
        return locationMapper.toDto(locationRepository.findByAddress(address));
    }

    @Override
    public Optional<LocationDTO> findByPlaceId(String placeId) {
        return locationRepository.findByPlaceId(placeId)
                .map(locationMapper::toDto);
    }

}
