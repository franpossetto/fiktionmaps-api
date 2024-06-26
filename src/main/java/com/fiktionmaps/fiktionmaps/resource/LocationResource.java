package com.fiktionmaps.fiktionmaps.resource;

import com.fiktionmaps.fiktionmaps.service.LocationService;
import com.fiktionmaps.fiktionmaps.service.dto.LocationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationResource {

    public final LocationService locationService;

    public LocationResource(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<LocationDTO>> getLocations() {
        List<LocationDTO> locations = locationService.getAll();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
}
