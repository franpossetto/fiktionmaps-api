package com.fiktionmaps.fiktionmaps.service.dto;

import com.fiktionmaps.fiktionmaps.model.Fiction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

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
    private List<PlaceDTO> places;
    private Integer year;
    private Integer duration;
    private String externalId;
    private Fiction.Provider provider;
    private String imgUrl;
    private Boolean published;
}
