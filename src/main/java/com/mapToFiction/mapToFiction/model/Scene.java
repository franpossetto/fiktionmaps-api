package com.mapToFiction.mapToFiction.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "scenes")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Scene {

    public enum SegmentType {
        MINUTE, PAGE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationSeq")
    @SequenceGenerator(name = "locationSeq", initialValue = 1, allocationSize = 1)
    private Long id;

    private String name;
    private String description;
    private String season;
    private String episodeName;
    private String episodeNumber;
    private Long startAt;
    private Long endAt;
    private String screenShot;

    @Enumerated(EnumType.STRING)
    private SegmentType segmentType;

    @ManyToOne
    @JoinColumn(name = "fiction_id")
    private Fiction fiction;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Scene(JsonNode sceneJsonNode) {
        this.name = sceneJsonNode.get("name").asText();
        this.description = sceneJsonNode.get("description").asText();
        this.season = sceneJsonNode.get("season").asText();
        this.episodeName = sceneJsonNode.get("episodeName").asText();
        this.episodeNumber = sceneJsonNode.get("episodeNumber").asText();
        this.startAt = sceneJsonNode.get("startAt").asLong();
        this.endAt = sceneJsonNode.get("endAt").asLong();
        this.segmentType = SegmentType.valueOf(sceneJsonNode.get("segmentType").asText().toUpperCase());
    }
}
