package com.mapToFiction.mapToFiction.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String season;
    private String name;
    private String number;
    private String sinopsis;

    @ManyToOne
    @JoinColumn(name = "fiction_id")
    private Fiction fiction;

    @OneToMany(mappedBy = "episode")
    private List<Scene> scenes;


}
