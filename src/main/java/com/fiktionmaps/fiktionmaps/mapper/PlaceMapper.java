package com.fiktionmaps.fiktionmaps.mapper;

import com.fiktionmaps.fiktionmaps.model.Place;
import com.fiktionmaps.fiktionmaps.service.dto.PlaceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LocationMapper.class, SceneMapper.class})
public interface PlaceMapper extends EntityMapper<PlaceDTO, Place> {
}

