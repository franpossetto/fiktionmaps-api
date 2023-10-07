package com.mapToFiction.mapToFiction.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.mapToFiction.mapToFiction.mapper.SceneMapper;
import com.mapToFiction.mapToFiction.model.*;
import com.mapToFiction.mapToFiction.service.*;
import com.mapToFiction.mapToFiction.service.dto.CityDTO;
import com.mapToFiction.mapToFiction.service.dto.FictionDTO;
import com.mapToFiction.mapToFiction.service.dto.LocationDTO;
import com.mapToFiction.mapToFiction.service.dto.SceneDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/v1/fictions")
public class FictionResource {
    private final LocationService locationService;
    private final FictionService fictionService;
    private final SceneService sceneService;
    private final GoogleMapsService googleMapsService;
    private final RowAPIDataService rowAPIDataService;
    public FictionResource(LocationService locationService, FictionService fictionService, SceneService sceneService, GoogleMapsService googleMapsService, RowAPIDataService rowAPIDataService) {
            this.locationService = locationService;
            this.fictionService = fictionService;
            this.sceneService = sceneService;
            this.googleMapsService = googleMapsService;
            this.rowAPIDataService = rowAPIDataService;
        }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<FictionDTO> getFictions(@RequestParam(required = false) Long cityId) {
        if (cityId != null) {
            return fictionService.getFictionsByCity(cityId);
        } else {
            return fictionService.getAll();
        }
    }

    @GetMapping("/scenes")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<SceneDTO> getScenes(@RequestHeader("Authorization") String token) {
        return sceneService.getAll();
    }

    // GET Fiction by ID



    //GET Cities by Fiction
    @GetMapping("/{id}/cities")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<CityDTO> GetCitiesByFiction(@RequestHeader("Authorization") String token, @PathVariable Long id){
        return fictionService.getCitiesByFiction(id);
    }

    // GET Scenes by Fiction

    // GET Scenes by Fiction and City

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addFiction(@Validated @RequestHeader("Authorization") String token, @RequestBody FictionDTO fictionDTO) {
        try {
            if (fictionDTO == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fiction or location not found in request");
            }

            if (fictionService.exists(fictionDTO.getName())) {
                String errorMessage = "Fiction '" + fictionDTO.getName() + "' already exists.";
                return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
            }

            fictionService.create(fictionDTO);
            String responseMessage = "Fiction '" + fictionDTO.getName() + "' has been created successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        } catch (Exception e) {
            String errorMessage = "Fiction '" + fictionDTO.getName() + "' could not be created.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PutMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Fiction> updateFiction(@RequestHeader("Authorization") String token, @PathVariable Long id, @RequestBody Fiction updateFiction){
        Fiction updatedFiction = fictionService.update(id, updateFiction);
        return new ResponseEntity<>(updatedFiction, HttpStatus.OK);
    }

    // DELETE Fiction
    @DeleteMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public void deleteFiction(@RequestHeader("Authorization") String token, @PathVariable Long id){
        fictionService.deleteFiction(id);
    }

    @PostMapping("/{id}/scenes")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addSceneToFiction(@PathVariable Long id, @RequestBody SceneDTO sceneDTO) {

        if (sceneDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Scene not found in request");
        }

        try {
            fictionService.addScene(id, sceneDTO);
            String responseMessage = "Scene '" + sceneDTO.getName() + "' has been successfully added to the fiction '" + id + "'.";
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        } catch (NoSuchElementException e) {
            String errorMessage = "Scene '" + sceneDTO.getName() + "' could not be created.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping("/{id}/scenes/{scene_id}/location")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addLocationToScene(@PathVariable Long id, @PathVariable Long scene_id, @RequestBody LocationDTO locationDto) {


        if (locationDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Location not found in request");
        }

        try {
            fictionService.addLocationToScene(id, scene_id, locationDto);
            String responseMessage = "Location '" + locationDto.getFormatted_address() + "' has been successfully added to the scene '" + scene_id + "'.";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fiction or scene not found");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding the location");
        }
    }
}

