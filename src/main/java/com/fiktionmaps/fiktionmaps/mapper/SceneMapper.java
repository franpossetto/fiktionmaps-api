package com.fiktionmaps.fiktionmaps.mapper;

import com.fiktionmaps.fiktionmaps.model.Scene;
import com.fiktionmaps.fiktionmaps.service.dto.SceneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SceneMapper extends EntityMapper<SceneDTO, Scene> {
    @Mapping(source = "user.id", target = "createdBy")
    SceneDTO toDto(Scene scene);

}