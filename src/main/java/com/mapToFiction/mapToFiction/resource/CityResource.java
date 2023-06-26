package com.mapToFiction.mapToFiction.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.mapToFiction.mapToFiction.model.City;
import com.mapToFiction.mapToFiction.service.CityService;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityResource {
    private final CityService cityService;

    public CityResource(CityService cityService){
        this.cityService= cityService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addCity(@RequestBody JsonNode cityJsonNode) {

        String responseMessage = "Todo ok. ";


        if (cityJsonNode == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("City not found in request");
        }
        City city = new City(cityJsonNode);

        cityService.create(city);
        responseMessage += "Scene created: " + city.getName() + ". ";

        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCities() {

        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City cityUpdate) {
        City updatedCity = cityService.updateCity(id, cityUpdate);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
