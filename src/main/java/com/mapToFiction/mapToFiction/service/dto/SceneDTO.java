package com.mapToFiction.mapToFiction.service.dto;

import com.mapToFiction.mapToFiction.model.Scene;
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
    private Scene.SegmentType segmentType;
    private Long fictionId;  // cambio de fiction a fictionId
    private LocationDTO location;
}

