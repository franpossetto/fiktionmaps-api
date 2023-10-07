package com.mapToFiction.mapToFiction.service;

import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.service.dto.SceneDTO;

import java.util.List;

public interface SceneService {
    Scene create(Scene scene);
    List<SceneDTO> getAll();
}
