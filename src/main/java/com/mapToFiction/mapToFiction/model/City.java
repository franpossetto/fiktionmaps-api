package com.mapToFiction.mapToFiction.model;

import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String placeId;
    private Double latitude;
    private Double longitude;
    private String provider;
    private String code;

    public City() {

    }

    public City(String name, String placeId, Double latitude, Double longitude, String provider, String code) {
        this.name = name;
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.provider = provider;
        this.code = code;
    }

    public City(JsonNode city) {
        this.name = city.get("name").asText();
        this.placeId = city.get("placeId").asText();
        this.latitude = city.get("latitude").asDouble();
        this.longitude = city.get("longitude").asDouble();
        this.provider = city.get("provider").asText();
        this.code = city.get("code").asText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
