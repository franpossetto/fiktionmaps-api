package com.mapToFiction.mapToFiction.service.dto;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FictionDTO {
    private Long id;
    @NotNull
    private String name;
    private Fiction.Type type;
    private List<SceneDTO> scenes;
    private Integer year;
    private Integer duration;
    private Integer externalId;
    private String fictionType;
    private String imgUrl;
}


