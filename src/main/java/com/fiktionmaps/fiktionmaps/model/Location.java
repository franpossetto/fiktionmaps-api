package com.fiktionmaps.fiktionmaps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "locations", uniqueConstraints = @UniqueConstraint(columnNames = "placeId"))
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locations_id_sequence")
    @SequenceGenerator(name = "locations_id_sequence", allocationSize = 1)
    private Long id;

    private String name;
    private String formattedAddress;
    private String placeId;
    private Double latitude;
    private Double longitude;
    private String type;
    private String postCode;
    private String provider;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Place> places = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public enum Provider {
        GOOGLE_MAPS, MAP_BOX, OPEN_STREET_MAP, CUSTOM
    }

    public enum Type {
        STREET, BUILDING, CAFFe, BOOK_STORE,
    }
}
