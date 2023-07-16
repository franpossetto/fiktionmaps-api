package com.mapToFiction.mapToFiction.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "scenes")
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
    private long startAt;
    private long endAt;
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

    public Scene() {}

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public long getStartAt() {
        return startAt;
    }

    public void setStartAt(long startAt) {
        this.startAt = startAt;
    }

    public long getEndAt() {
        return endAt;
    }

    public void setEndAt(long endAt) {
        this.endAt = endAt;
    }

    public SegmentType getSegmentType() {
        return segmentType;
    }

    public void setSegmentType(SegmentType segmentType) {
        this.segmentType = segmentType;
    }

    public Fiction getFiction() {
        return fiction;
    }

    public void setFiction(Fiction fiction) {
        this.fiction = fiction;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}