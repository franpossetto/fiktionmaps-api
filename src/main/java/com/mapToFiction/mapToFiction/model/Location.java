package com.mapToFiction.mapToFiction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "locations", uniqueConstraints = @UniqueConstraint(columnNames = "placeId"))
public class Location {

    public enum Provider {
        GOOGLE_MAPS, MAP_BOX, OPEN_STREET_MAP, CUSTOM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationSeq")
    @SequenceGenerator(name = "locationSeq", initialValue = 1, allocationSize = 1)
    private Long id;

    private String formattedAddress;
    private String placeId;
    private Double latitude;
    private Double longitude;
    private String provider;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Scene> scenes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public Location() {}

    public Location(Location location) {
        if (location.getId() != null) {
            this.id = location.getId();
        }
        if (location.getFormatted_address() != null) {
            this.formattedAddress = location.getFormatted_address();
        }
        if (location.getPlace_id() != null) {
            this.placeId = location.getPlace_id();
        }
        if (location.getLatitude() != null) {
            this.latitude = location.getLatitude();
        }
        if (location.getLongitude() != null) {
            this.longitude = location.getLongitude();
        }
        if (location.getProvider() != null) {
            this.provider = location.getProvider();
        }
        if (location.getScenes() != null) {
            this.scenes = location.getScenes();
        }
    }

    public Location(JsonNode locationJsonNode) {
        this.formattedAddress = locationJsonNode.get("formattedAddress").asText();
        this.placeId = locationJsonNode.get("placeId").asText();
        this.latitude = locationJsonNode.get("latitude").asDouble();
        this.longitude = locationJsonNode.get("longitude").asDouble();
        this.provider = locationJsonNode.get("provider").asText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormatted_address() {
        return formattedAddress;
    }

    public void setFormatted_address(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getPlace_id() {
        return placeId;
    }

    public void setPlace_id(String placeId) {
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

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
