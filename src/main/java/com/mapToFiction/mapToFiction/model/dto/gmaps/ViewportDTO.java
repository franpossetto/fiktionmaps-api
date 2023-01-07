package com.mapToFiction.mapToFiction.model.dto.gmaps;

public class ViewportDTO {
    public NortheastDTO northeast;
    public SouthwestDTO southwest;

    public NortheastDTO getNortheast() {
        return northeast;
    }

    public void setNortheast(NortheastDTO northeast) {
        this.northeast = northeast;
    }

    public SouthwestDTO getSouthwest() {
        return southwest;
    }

    public void setSouthwest(SouthwestDTO southwest) {
        this.southwest = southwest;
    }
}
