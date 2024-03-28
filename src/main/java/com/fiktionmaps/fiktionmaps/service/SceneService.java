package com.fiktionmaps.fiktionmaps.service;

import com.fiktionmaps.fiktionmaps.service.dto.SceneDTO;

import java.util.List;

public interface SceneService {

    SceneDTO create(SceneDTO scene);
    List<SceneDTO> getAll();
}
