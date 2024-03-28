package com.fiktionmaps.fiktionmaps.service.impl;

import com.fiktionmaps.fiktionmaps.mapper.SceneMapper;
import com.fiktionmaps.fiktionmaps.model.Scene;
import com.fiktionmaps.fiktionmaps.repository.SceneRepository;
import com.fiktionmaps.fiktionmaps.service.SceneService;
import com.fiktionmaps.fiktionmaps.service.dto.SceneDTO;
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
    public SceneDTO create(SceneDTO sceneDto) {
        Scene scene = sceneRepository.save(sceneMapper.toEntity(sceneDto));
        return sceneMapper.toDto(scene);
    }

    @Override
    public List<SceneDTO> getAll() {
        List<Scene> scenes = sceneRepository.findAll();
        return sceneMapper.toDtoList(scenes);
    }


}