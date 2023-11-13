package com.mapToFiction.mapToFiction.mapper;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.repository.FictionRepository;
import com.mapToFiction.mapToFiction.service.dto.SceneDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SceneMapper extends EntityMapper<SceneDTO, Scene> {

    @Mapping(source = "location.city.id", target = "location.cityId")
    @Mapping(source = "user.id", target = "userId")
    SceneDTO toDto(Scene scene);

    @Mapping(source = "location.cityId", target = "location.city.id")
    @Mapping(source = "userId", target = "user.id")
    Scene toEntity(SceneDTO sceneDTO);

}



