package com.mapToFiction.mapToFiction.mapper;
import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.service.dto.LocationDTO;
import com.mapToFiction.mapToFiction.service.dto.SceneDTO;
import org.mapstruct.*;


import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper extends EntityMapper<LocationDTO, Location> {
    @Mapping(source = "city.id", target = "cityId")
    LocationDTO toDto(Location location);

    @Mapping(source = "cityId", target = "city.id")
    Location toEntity(LocationDTO locationDTO);
}
