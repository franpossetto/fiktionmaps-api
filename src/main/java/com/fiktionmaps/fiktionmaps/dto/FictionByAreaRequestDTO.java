package com.fiktionmaps.fiktionmaps.dto;
import lombok.Data;

@Data
public class FictionByAreaRequestDTO {
    private double upperLat;
    private double lowerLat;
    private double rightLng;
    private double leftLng;

    public FictionByAreaRequestDTO(double upperLat, double lowerLat, double rightLng, double leftLng) {
        this.upperLat = upperLat;
        this.lowerLat = lowerLat;
        this.rightLng = rightLng;
        this.leftLng = leftLng;
    }
} 