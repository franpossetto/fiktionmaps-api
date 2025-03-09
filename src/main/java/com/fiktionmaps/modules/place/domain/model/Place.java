package com.fiktionmaps.modules.place.domain.model;

import com.fiktionmaps.modules.fiction.domain.Fiction;
import com.fiktionmaps.modules.location.domain.Location;
import com.fiktionmaps.modules.user.domain.User;

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
@ToString(exclude = {"fiction", "location", "scenes", "user"})
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "places_id_sequence")
    @SequenceGenerator(name = "places_id_sequence", allocationSize = 1)
    private Long id;

    private String name;
    private String description;
    private String screenshot;
    private Boolean published;

    @ManyToOne
    @JoinColumn(name = "fiction_id")
    private Fiction fiction;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Scene> scenes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;

}

