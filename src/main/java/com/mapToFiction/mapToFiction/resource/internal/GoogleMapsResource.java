package com.mapToFiction.mapToFiction.resource.internal;

import com.mapToFiction.mapToFiction.model.dto.gmaps.ResultsDTO;
import com.mapToFiction.mapToFiction.service.GoogleMapsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gmaps")
public class GoogleMapsResource {
    private final GoogleMapsService googleMapsService;

    public GoogleMapsResource(GoogleMapsService googleMapsService) {
        this.googleMapsService = googleMapsService;
    }

    @GetMapping("/{address}")
    public ResultsDTO
    getAll(@PathVariable String address) {
        return googleMapsService.getPlace(address);
    }
}
