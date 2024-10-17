
package com.fiktionmaps.fiktionmaps.dto;
import lombok.Data;

@Data
public class PlaceByAreaRequestDTO {
    private double upperLat;
    private double lowerLat;
    private double rightLng;
    private double leftLng;
    private Long fictionId;

    // Constructor con todos los parámetros
    public PlaceByAreaRequestDTO(double upperLat, double lowerLat, double rightLng, double leftLng, Long fictionId) {
        this.upperLat = upperLat;
        this.lowerLat = lowerLat;
        this.rightLng = rightLng;
        this.leftLng = leftLng;
        this.fictionId = fictionId;
    }
}
