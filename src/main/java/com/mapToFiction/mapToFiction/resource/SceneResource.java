package com.mapToFiction.mapToFiction.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.service.FictionService;
import com.mapToFiction.mapToFiction.service.SceneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/scenes")
public class SceneResource {

    private final SceneService sceneService;
    private final FictionService fictionService;


    public SceneResource(SceneService sceneService, FictionService fictionService) {
        this.sceneService = sceneService;
        this.fictionService = fictionService;
    }


    @PostMapping("/create")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody JsonNode sceneJsonNode) {

        if (sceneJsonNode == null || !sceneJsonNode.hasNonNull("fiction")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fiction or location not found in request");
        }

        Fiction fiction = fictionService.getById(sceneJsonNode.get("fiction").asLong());
        if (fiction == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fiction not found");
        }

        Scene scene = new Scene(sceneJsonNode);
        scene.setFiction(fiction);

        List<Scene> scenes = fiction.getScenes();
        if (scenes == null) {
            scenes = new ArrayList<>();
        }
        scenes.add(scene);
        fiction.setScenes(scenes);
        fictionService.update(fiction);

        // The Scene is saved after the Fiction is set and updated
        sceneService.create(scene);

        return ResponseEntity.ok("Todo ok.");

    }

}
