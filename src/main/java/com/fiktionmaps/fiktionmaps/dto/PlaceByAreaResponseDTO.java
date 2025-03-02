package com.fiktionmaps.fiktionmaps.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaceByAreaResponseDTO {

    private Long placeId;
    private double latitude;
    private double longitude;
    private String screenshot;
    public PlaceByAreaResponseDTO(Long placeId, double latitude, double longitude, String screenshot) {
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.screenshot = screenshot;
    }
}

