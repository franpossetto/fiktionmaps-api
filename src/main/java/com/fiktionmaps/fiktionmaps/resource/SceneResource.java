package com.fiktionmaps.fiktionmaps.resource;

import com.fiktionmaps.fiktionmaps.service.FictionService;
import com.fiktionmaps.fiktionmaps.service.SceneService;
import com.fiktionmaps.fiktionmaps.service.dto.SceneDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/scenes")
public class SceneResource {

    private final SceneService sceneService;

    public SceneResource(SceneService sceneService, FictionService fictionService) {
        this.sceneService = sceneService;
    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<SceneDTO> getScenes(@RequestHeader("Authorization") String token) {
        return sceneService.getAll();
    }

}
