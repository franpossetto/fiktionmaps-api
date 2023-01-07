package com.mapToFiction.mapToFiction.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "cities", uniqueConstraints = @UniqueConstraint(columnNames = "placeId"))
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String name;
    private String placeId;

    @Enumerated(EnumType.STRING)
    private Provider provider;

    // A city can have many maps.
    @OneToMany(mappedBy = "city")
    private List<Map> maps;

    // A city can have many maps.
    @OneToMany(mappedBy = "city")
    private List<Location> locations;

    public enum Provider {
        GOOGLE_MAPS, MAP_BOX, OPEN_STREET_MAP, CUSTOM
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "place_id")
    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public City(){};

    public City(String name, String country, String placeId, Provider provider) {
        this.name = name;
        this.country = country;
        this.placeId = placeId;
        this.provider = provider;
    }
}
