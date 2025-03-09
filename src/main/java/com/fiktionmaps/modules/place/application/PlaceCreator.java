package com.fiktionmaps.modules.place.application;

import com.fiktionmaps.modules.fiction.domain.Fiction;
import com.fiktionmaps.modules.location.domain.Location;
import com.fiktionmaps.modules.place.domain.model.Place;
import com.fiktionmaps.modules.place.domain.repository.PlaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PlaceCreator {
    private final PlaceRepository placeRepository;

    public PlaceCreator(PlaceRepository placeRepository){
        this.placeRepository=placeRepository;
        // this.locationService =
        // this.locationRepository =
    }


    @Transactional
    public Place create(Place place, Fiction fiction) {

        if (fiction != null) {
            place.setFiction(fiction);
        }

        Location loc = handleLocation(dto.getLocation());
        place.setLocation(loc);

        if (place.getUserId() != null) {
            setUser(place, dto.getUserId());
        }

        return placeRepository.save(place);
    }
}
