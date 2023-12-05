package com.fiktionmaps.fiktionmaps.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "places")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "placeSeq")
    @SequenceGenerator(name = "placeSeq", initialValue = 1000, allocationSize = 1)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "fiction_id")
    private Fiction fiction;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Scene> scenes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;

}
