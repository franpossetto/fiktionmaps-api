package com.mapToFiction.mapToFiction.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.mapToFiction.mapToFiction.model.*;
import com.mapToFiction.mapToFiction.model.dto.gmaps.ResultsDTO;
import com.mapToFiction.mapToFiction.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fictions")
public class FictionResource {
        private final LocationService locationService;
        private final FictionService fictionService;
        private final SceneService sceneService;
        private final GoogleMapsService googleMapsService;

        public FictionResource(LocationService locationService, FictionService fictionService, SceneService sceneService, GoogleMapsService googleMapsService) {
            this.locationService = locationService;
            this.fictionService = fictionService;
            this.sceneService = sceneService;
            this.googleMapsService = googleMapsService;
        }

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addFictionLocation(@RequestBody JsonNode fictionMap) {

        JsonNode fictionJsonNode = fictionMap.get("fiction");
        JsonNode locationJsonNode = fictionMap.get("location");
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

        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);

    }
}

