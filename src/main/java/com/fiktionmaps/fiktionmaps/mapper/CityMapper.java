package com.fiktionmaps.fiktionmaps.mapper;

import com.fiktionmaps.fiktionmaps.model.City;
import com.fiktionmaps.fiktionmaps.service.dto.CityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper extends EntityMapper<CityDTO, City> {
}
