package com.mapToFiction.mapToFiction.service.impl;

import com.mapToFiction.mapToFiction.mapper.LocationMapper;
import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.repository.LocationRepository;
import com.mapToFiction.mapToFiction.service.LocationService;
import com.mapToFiction.mapToFiction.service.dto.LocationDTO;
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
    public Location create(Location location) {
        Location address = new Location(location);
        return locationRepository.save(address);
    }

    @Override
    public Location findByAddress(String address) {
        return locationRepository.findByAddress(address);
    }

    @Override
    public Optional<Location> findByPlaceId(String placeId) {
        return locationRepository.findByPlaceId(placeId);
    }
}
