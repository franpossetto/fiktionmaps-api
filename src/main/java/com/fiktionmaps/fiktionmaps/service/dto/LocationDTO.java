package com.fiktionmaps.fiktionmaps.service.dto;

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
    private String placeId;
    private String formattedAddress;
    private String postCode;
    private Long cityId;
}
