package com.fiktionmaps.modules.location.application;

import com.fiktionmaps.modules.location.domain.Location;
import com.fiktionmaps.modules.location.domain.LocationRepository;

import java.util.Optional;

public class CreateLocationIfNotExists {

    private final LocationRepository locationRepository;

    public CreateLocationIfNotExists(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public Optional<Location> execute(Location location){
        return Optional.of(locationRepository.findByPlaceId(location.getPlaceId())
                .orElseGet(() -> locationRepository.save(location)));
    }
}
