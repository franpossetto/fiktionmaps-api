package com.mapToFiction.mapToFiction.service;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.service.dto.FictionDTO;
import com.mapToFiction.mapToFiction.service.dto.SceneDTO;

import java.util.List;

public interface FictionService {
    FictionDTO create(FictionDTO fictionDto);
    Fiction update(Fiction fiction);
    Fiction update(Long id, Fiction fiction);
    boolean exists(String name);
    List<FictionDTO> getAll();
    Fiction getById(Long id);
    Fiction findByName(String name);
    FictionDTO addScene(Long id, SceneDTO sceneDto);
    Scene addLocationToScene(Long fictionId, Long sceneId, Location location);
    void deleteFiction(Long id);
}
