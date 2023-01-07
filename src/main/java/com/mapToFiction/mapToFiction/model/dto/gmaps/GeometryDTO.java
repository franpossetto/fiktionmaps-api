package com.mapToFiction.mapToFiction.model.dto.gmaps;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeometryDTO {
    public BoundsDTO bounds;
    public LocationDTO location;

    @JsonProperty("location_type")
    public String locationType;

    public ViewportDTO viewport;
}

