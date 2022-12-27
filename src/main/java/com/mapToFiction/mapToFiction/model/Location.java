package com.mapToFiction.mapToFiction.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String address;

    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "location")
    private List<Scene> scenes;

}
