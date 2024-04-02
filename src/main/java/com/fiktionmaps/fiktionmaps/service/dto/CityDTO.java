package com.fiktionmaps.fiktionmaps.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private Long id;
    private String name;
    private String placeId;
    private Double latitude;
    private Double longitude;
    private String provider;
    private String code;
    private List<LocationDTO> locations = new ArrayList<>();
    private Long amountOfPlaces;
}
