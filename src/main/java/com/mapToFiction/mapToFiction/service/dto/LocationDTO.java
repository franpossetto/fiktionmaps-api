package com.mapToFiction.mapToFiction.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LocationDTO {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String provider;
    private String place_id;
    private String formatted_address;
    private Long city_id;
}

