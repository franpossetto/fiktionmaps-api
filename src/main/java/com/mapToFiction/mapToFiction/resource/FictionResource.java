package com.mapToFiction.mapToFiction.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.mapToFiction.mapToFiction.model.*;
import com.mapToFiction.mapToFiction.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/map")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addFictionMap(@RequestBody JsonNode fictionMap) {

        JsonNode fictionJsonNode = fictionMap.get("fiction");
        JsonNode locationJsonNode = fictionMap.get("location");
        JsonNode rowAPIDataJsonNode = fictionMap.get("row");
        String responseMessage = "Todo ok. ";

        if (fictionJsonNode == null || locationJsonNode == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fiction or location not found in request");
        }

        Fiction fiction = new Fiction(fictionJsonNode);

        if (fictionService.findByName(fiction.getName()) == null) {
            fictionService.create(fiction);
            responseMessage += "Fiction created: " + fiction.getName() + ". ";
        }

        List<Scene> scenes = fiction.getScenes();
        if (scenes != null && !scenes.isEmpty()) {
            Scene scene = scenes.get(0);
            if (fiction.getId() != null) {
                scene.setFiction(fiction);
            } else {
                Fiction persistedFiction = fictionService.findByName(fiction.getName());
                if (persistedFiction != null) {
                    scene.setFiction(persistedFiction);
                } else {
                    scene.setFiction(fiction);
                }
            }
            sceneService.create(scene);
            responseMessage += "Scene created: " + scene.getName() + ". ";
        }

        Location location = new Location(locationJsonNode);
        Location loc = locationService.findByPlaceId(location.getPlace_id());

        if (loc == null) {
            loc = locationService.create(location);
            responseMessage += "Location created: " + loc.getFormatted_address() + ". ";
        }

        RowAPIData rowAPIData = new RowAPIData(rowAPIDataJsonNode);
        rowAPIDataService.create(rowAPIData);

        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);

    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<Fiction> getFictions() {
        return fictionService.getAll();
    }

    // GET Fiction by ID

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addFiction(@RequestBody JsonNode fictionJsonNode) {

        String responseMessage = "Todo ok. ";

        if (fictionJsonNode == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fiction or location not found in request");
        }

        Fiction fiction = new Fiction(fictionJsonNode);
        fictionService.create(fiction);
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }

    @PutMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Fiction> updateFiction(@PathVariable Long id, @RequestBody Fiction updateFiction){
        Fiction updatedFiction = fictionService.update(id, updateFiction);
        return new ResponseEntity<>(updatedFiction, HttpStatus.OK);
    }

    // DELETE Fiction
    @DeleteMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public void deleteFiction(@PathVariable Long id){
        fictionService.deleteFiction(id);
    }

    @PostMapping("/{id}/scenes")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addSceneToFiction(@PathVariable Long id, @RequestBody Scene scene) {

        String responseMessage = "Todo ok. ";

        if (scene == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Scene not found in request");
        }

        try {
            fictionService.addScene(id, scene);
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fiction not found");
        }
    }

    @PostMapping("/{id}/scenes/{scene_id}/location")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addLocationToScene(@PathVariable Long id, @PathVariable Long scene_id, @RequestBody Location location) {

        String responseMessage = "Location added successfully. ";

        if (location == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Location not found in request");
        }

        try {
            fictionService.addLocationToScene(id, scene_id, location);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fiction or scene not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding the location");
        }
    }

}

