package com.mapToFiction.mapToFiction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "locations", uniqueConstraints = @UniqueConstraint(columnNames = "placeId"))
@Getter
@Setter
@NoArgsConstructor
public class Location {

    public enum Provider {
        GOOGLE_MAPS, MAP_BOX, OPEN_STREET_MAP, CUSTOM
    }

    public enum Type {
        STREET, BUILDING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationSeq")
    @SequenceGenerator(name = "locationSeq", initialValue = 1000, allocationSize = 1)
    private Long id;

    private String name;
    private String formattedAddress;
    private String placeId;
    private Double latitude;
    private Double longitude;
    private String type;
    private String postCode;
    private String provider;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Scene> scenes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Location(Location location) {
        if (location.getId() != null) {
            this.id = location.getId();
        }
        if (location.getFormattedAddress() != null) {
            this.formattedAddress = location.getFormattedAddress();
        }
        if (location.getPlaceId() != null) {
            this.placeId = location.getPlaceId();
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
        if (location.getType() != null) {
            this.type = location.getType();
        }
    }
}
