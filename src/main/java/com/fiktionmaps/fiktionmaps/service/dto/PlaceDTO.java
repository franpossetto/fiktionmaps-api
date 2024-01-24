package com.fiktionmaps.fiktionmaps.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiktionmaps.fiktionmaps.model.Scene;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlaceDTO {
    private Long id;
    private String name;
    private String description;
    private String fictionId;
    private LocationDTO location;
    private List<SceneDTO> scenes;
    private String screenshot;
    private Long userId;
    private String userEmail;
    private Boolean published;
}
