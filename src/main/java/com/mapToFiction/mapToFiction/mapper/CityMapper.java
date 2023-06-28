package com.mapToFiction.mapToFiction.mapper;
import com.mapToFiction.mapToFiction.model.City;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.service.dto.CityDTO;
import com.mapToFiction.mapToFiction.service.dto.FictionDTO;
import com.mapToFiction.mapToFiction.service.dto.LocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SceneMapper.class)
public interface CityMapper extends EntityMapper<CityDTO, City> {
    @Mapping(source = "city.id", target = "city_id")
    LocationDTO toDto(Location location);

    @Mapping(source = "city_id", target = "city.id")
    Location toEntity(LocationDTO locationDTO);
}
