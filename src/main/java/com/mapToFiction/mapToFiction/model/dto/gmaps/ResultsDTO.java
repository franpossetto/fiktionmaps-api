package com.mapToFiction.mapToFiction.model.dto.gmaps;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ResultsDTO {

    @JsonProperty("address_components")
    public ArrayList<AddressComponentDTO> addressComponents;

    @JsonProperty("formatted_address")
    public String formattedAddress;

    public GeometryDTO geometry;

    @JsonProperty("place_id")
    public String placeId;

    public ArrayList<String> types;



}
