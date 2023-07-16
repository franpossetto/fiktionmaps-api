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

    @Mapping(source = "location.city.id", target = "location.city_id")
    @Mapping(source = "user.id", target = "user_id")
    SceneDTO toDto(Scene scene);

    @Mapping(source = "location.city_id", target = "location.city.id")
    @Mapping(source = "user_id", target = "user.id")
    Scene toEntity(SceneDTO sceneDTO);

}



