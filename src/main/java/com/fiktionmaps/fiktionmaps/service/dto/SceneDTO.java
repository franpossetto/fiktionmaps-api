package com.fiktionmaps.fiktionmaps.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.fiktionmaps.fiktionmaps.model.Scene;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SceneDTO {
    private Long id;
    private String name;
    private String description;
    private String season;
    private String episodeName;
    private String episodeNumber;
    private Long startAt;
    private Long endAt;
    private String screenshot;
    private Scene.SegmentType segmentType;

    @JsonIgnore
    private Long fictionId;

    @JsonIgnore
    private Long createdBy;
}
