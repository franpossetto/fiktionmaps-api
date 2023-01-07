package com.mapToFiction.mapToFiction.model;
import javax.persistence.*;
import java.util.List;

import javax.persistence.Entity;

@Entity
@Table(name="maps")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;


    @ManyToOne()
    @JoinColumn(name = "fiction_id")
    private Fiction fiction;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "map")
    private List<Scene> scenes;
}
