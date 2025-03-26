package com.fiktionmaps.fiktionmaps.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FictionByAreaResponseDTO {
    private Long fictionId;
    private String name;
    private String type;
    private Integer year;
    private Integer duration;
    private String imgUrl;
    private Boolean published;

    public FictionByAreaResponseDTO(Long fictionId, String name, String type, Integer year, 
                                  Integer duration, String imgUrl, Boolean published) {
        this.fictionId = fictionId;
        this.name = name;
        this.type = type;
        this.year = year;
        this.duration = duration;
        this.imgUrl = imgUrl;
        this.published = published;
    }
} 