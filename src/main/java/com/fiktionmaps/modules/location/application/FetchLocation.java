package com.fiktionmaps.modules.location.application;

import com.fiktionmaps.modules.location.domain.Location;
import com.fiktionmaps.modules.location.domain.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FetchLocation {

    private final LocationRepository locationRepository;

    public FetchLocation(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public Optional<Location> execute(String locationId){
        return locationRepository.findByPlaceId(locationId);

    }
}
