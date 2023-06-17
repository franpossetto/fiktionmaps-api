package com.mapToFiction.mapToFiction.service;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.service.dto.FictionDTO;

import java.util.List;

public interface FictionService {
    Fiction create(Fiction fiction);
    Fiction update(Fiction fiction);
    Fiction update(Long id, Fiction fiction);
    void delete(Long id);
    List<Fiction> getAll();
    Fiction getById(Long id);
    Fiction findByName(String name);
    Fiction addScene(Long id, Scene scene);
    Scene addLocationToScene(Long fictionId, Long sceneId, Location location);
    void deleteFiction(Long id);
}
