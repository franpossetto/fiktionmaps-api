package com.mapToFiction.mapToFiction.service.impl;
import com.mapToFiction.mapToFiction.mapper.SceneMapper;
import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.repository.SceneRepository;
import com.mapToFiction.mapToFiction.service.SceneService;
import com.mapToFiction.mapToFiction.service.dto.SceneDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneServiceImpl implements SceneService {
    private final SceneRepository sceneRepository;
    private final SceneMapper sceneMapper;

    SceneServiceImpl(SceneRepository sceneRepository, SceneMapper sceneMapper) {
        this.sceneRepository = sceneRepository;
        this.sceneMapper = sceneMapper;
    }
    @Override
    public Scene create(Scene scene) {
        return sceneRepository.save(scene);
    }

    @Override
    public List<SceneDTO> getAll() {
        List<Scene> scenes = sceneRepository.findAll();
        return sceneMapper.toDtoList(scenes);
    }


}
