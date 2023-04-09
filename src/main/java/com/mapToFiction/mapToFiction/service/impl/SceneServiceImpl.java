package com.mapToFiction.mapToFiction.service.impl;

import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.repository.SceneRepository;
import com.mapToFiction.mapToFiction.service.SceneService;
import org.springframework.stereotype.Service;

@Service
public class SceneServiceImpl implements SceneService {
    private final SceneRepository sceneRepository;

    SceneServiceImpl(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }
    @Override
    public Scene create(Scene scene) {
        return sceneRepository.save(scene);
    }

}
