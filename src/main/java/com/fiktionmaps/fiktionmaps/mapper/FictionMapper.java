package com.fiktionmaps.fiktionmaps.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.fiktionmaps.fiktionmaps.model.Fiction;
import com.fiktionmaps.fiktionmaps.service.dto.FictionDTO;

@Mapper(componentModel = "spring", uses = PlaceMapper.class)
public interface FictionMapper extends EntityMapper<FictionDTO, Fiction> {

}
