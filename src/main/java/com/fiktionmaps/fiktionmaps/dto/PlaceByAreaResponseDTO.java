package com.fiktionmaps.fiktionmaps.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaceByAreaResponseDTO {

    private Long placeId;
    private double latitude;
    private double longitude;
    public PlaceByAreaResponseDTO(Long placeId, double latitude, double longitude) {
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

