package com.mapToFiction.mapToFiction.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.mapToFiction.mapToFiction.model.City;
import com.mapToFiction.mapToFiction.service.CityService;
import com.mapToFiction.mapToFiction.service.dto.CityDTO;
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

        if (cityJsonNode == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("City not found in request");
        }

        City city = new City(cityJsonNode);

        cityService.create(city);
        String responseMessage = "The city " + city.getName() + " has been created. ";

        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);

    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCities() {
        List<CityDTO> cities = cityService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public CityDTO GetCitiesById(@RequestHeader("Authorization") String token, @PathVariable Long id){
        return cityService.getCityById(id);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City cityUpdate) {
        City updatedCity = cityService.updateCity(id, cityUpdate);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
