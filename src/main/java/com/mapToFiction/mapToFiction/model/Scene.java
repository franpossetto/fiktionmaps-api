package com.mapToFiction.mapToFiction.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "scenes")
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "fiction_id")
    private Fiction fiction;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne()
    @JoinColumn(name="map_id")
    private Map map;
}
