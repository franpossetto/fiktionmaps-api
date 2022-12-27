package com.mapToFiction.mapToFiction.model;
import javax.persistence.*;
import java.util.List;

import javax.persistence.Entity;

@Entity
@Table(name="maps")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String city;

    @ManyToOne()
    @JoinColumn(name = "fiction_id")
    private Fiction fiction;

    @OneToMany(mappedBy = "map")
    private List<Scene> scenes;
}
