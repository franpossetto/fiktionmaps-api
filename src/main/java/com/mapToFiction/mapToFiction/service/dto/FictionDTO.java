package com.mapToFiction.mapToFiction.service.dto;
import com.mapToFiction.mapToFiction.model.Fiction;
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
    private String name;
    private Fiction.Type type;
    private List<SceneDTO> scenes;
    private String fictionType;
}


