package com.mapToFiction.mapToFiction.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citySeq")
    @SequenceGenerator(name = "citySeq", initialValue = 1, allocationSize = 1)
    private Long id;
    private String name;
    private String placeId;
    private Double latitude;
    private Double longitude;
    private String provider;
    private String code;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<>();

    public City(String name, String placeId, Double latitude, Double longitude, String provider, String code) {
        this.name = name;
        this.placeId = placeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.provider = provider;
        this.code = code;
    }

    public City(JsonNode city) {
        this.name = city.get("name").asText();
        this.placeId = city.get("placeId").asText();
        this.latitude = city.get("latitude").asDouble();
        this.longitude = city.get("longitude").asDouble();
        this.provider = city.get("provider").asText();
        this.code = city.get("code").asText();
    }
}
