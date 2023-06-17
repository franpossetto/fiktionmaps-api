package com.mapToFiction.mapToFiction.mapper;
import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.service.dto.LocationDTO;
import org.mapstruct.*;


import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper extends EntityMapper<LocationDTO, Location> {
}
