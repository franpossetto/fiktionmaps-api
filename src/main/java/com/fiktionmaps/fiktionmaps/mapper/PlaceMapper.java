package com.fiktionmaps.fiktionmaps.mapper;

import com.fiktionmaps.fiktionmaps.model.Place;
import com.fiktionmaps.fiktionmaps.service.dto.PlaceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LocationMapper.class, SceneMapper.class, FictionMapper.class})
public interface PlaceMapper extends EntityMapper<PlaceDTO, Place> {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.email", target = "userEmail")
    @Mapping(source = "fiction.id", target = "fictionId")
    PlaceDTO toDto(Place place);
}

