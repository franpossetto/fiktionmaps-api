package com.mapToFiction.mapToFiction.model.dto.gmaps;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class AddressComponentDTO {

    @JsonProperty("long_name")
    public String longName;

    @JsonProperty("short_name")
    public String shortName;

    public ArrayList<String> types;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public AddressComponentDTO(){}
}
