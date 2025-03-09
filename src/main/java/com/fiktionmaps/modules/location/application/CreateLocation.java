package com.fiktionmaps.modules.location.application;

import com.fiktionmaps.fiktionmaps.mapper.LocationMapper;
import com.fiktionmaps.fiktionmaps.model.Location;
import com.fiktionmaps.fiktionmaps.repository.LocationRepository;
import com.fiktionmaps.fiktionmaps.service.dto.LocationDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateLocation {

    public final LocationRepository locationRepository;
    public final LocationMapper locationMapper;

    public CreateLocation(LocationRepository locationRepository, LocationMapper locationMapper){
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    public LocationDTO handle(LocationDTO locationDto) {
        Location location = locationMapper.toEntity(locationDto);
        return locationMapper.toDto(locationRepository.save(location));
    }

}
