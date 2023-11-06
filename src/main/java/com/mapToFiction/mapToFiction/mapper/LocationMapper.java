package com.mapToFiction.mapToFiction.mapper;
import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.model.Scene;
import com.mapToFiction.mapToFiction.service.dto.LocationDTO;
import com.mapToFiction.mapToFiction.service.dto.SceneDTO;
import org.mapstruct.*;


import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper extends EntityMapper<LocationDTO, Location> {
    @Mapping(source = "placeId", target = "place_id")
    @Mapping(source = "city.id", target = "city_id")
    @Mapping(source = "formattedAddress", target = "formatted_address")
    LocationDTO toDto(Location location);

    @Mapping(source = "place_id", target = "placeId")
    @Mapping(source = "city_id", target = "city.id")
    @Mapping(source = "formatted_address", target = "formattedAddress")
    Location toEntity(LocationDTO locationDTO);
}
