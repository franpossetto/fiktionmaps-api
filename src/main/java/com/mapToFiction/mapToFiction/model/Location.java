package com.mapToFiction.mapToFiction.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "locations", uniqueConstraints = @UniqueConstraint(columnNames = "place_id"))
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String formatted_address;
    private String place_id;
    private Double latitude;
    private Double longitude;
    private String provider;


    @OneToMany(mappedBy = "location")
    private List<Scene> scenes;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    private City city;
    public enum Provider {
        GOOGLE_MAPS, MAP_BOX, OPEN_STREET_MAP, CUSTOM
    }

}
