package com.fiktionmaps.fiktionmaps.mapper;

import com.fiktionmaps.fiktionmaps.model.Location;
import com.fiktionmaps.fiktionmaps.service.dto.LocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper extends EntityMapper<LocationDTO, Location> {
    @Mapping(source = "city.id", target = "cityId")
    LocationDTO toDto(Location location);

    @Mapping(source = "cityId", target = "city.id")
    Location toEntity(LocationDTO locationDTO);
}
