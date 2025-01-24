package com.fiktionmaps.fiktionmaps.dto;

import com.fiktionmaps.fiktionmaps.service.dto.LocationDTO;
import com.fiktionmaps.fiktionmaps.service.dto.SceneDTO;

import java.util.List;

public class PlaceByIdResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String fictionName;
    private LocationDTO location;
    private List<SceneDTO> scenes;
    private String screenshot;
    private Long userId;
    private String userEmail;
    private Boolean published;
}
