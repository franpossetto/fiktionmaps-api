package com.fiktionmaps.fiktionmaps.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citySeq")
    @SequenceGenerator(name = "citySeq", initialValue = 1000, allocationSize = 1)
    private Long id;
    private String name;
    private String placeId;
    private Double latitude;
    private Double longitude;
    private String provider;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<>();

}
