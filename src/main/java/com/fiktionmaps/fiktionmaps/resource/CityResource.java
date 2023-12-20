package com.fiktionmaps.fiktionmaps.resource;

import com.fiktionmaps.fiktionmaps.service.CityService;
import com.fiktionmaps.fiktionmaps.service.dto.CityDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cities")
public class CityResource {
    private final CityService cityService;

    public CityResource(CityService cityService){
        this.cityService= cityService;
    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CityDTO>> getCities() {
        List<CityDTO> cities = cityService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(cities);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<CityDTO> getCitiesById(@PathVariable Long id) {
        CityDTO cityDto = cityService.getById(id);
        if (cityDto != null) {
            return ResponseEntity.ok(cityDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
