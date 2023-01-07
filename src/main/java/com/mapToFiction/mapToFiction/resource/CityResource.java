package com.mapToFiction.mapToFiction.resource;

import com.mapToFiction.mapToFiction.model.City;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.service.CityService;
import com.mapToFiction.mapToFiction.service.FictionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cities")
public class CityResource {
    private final CityService cityService;

    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCity(@RequestBody String city) {
        cityService.add(city);
    }

}
