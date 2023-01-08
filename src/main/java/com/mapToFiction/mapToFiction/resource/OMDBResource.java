package com.mapToFiction.mapToFiction.resource;

import com.mapToFiction.mapToFiction.model.dto.omdb.OMDBFiction;
import com.mapToFiction.mapToFiction.model.dto.omdb.OMDBMovieDTO;
import com.mapToFiction.mapToFiction.model.dto.omdb.OMDBSerieDTO;
import com.mapToFiction.mapToFiction.service.OMDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/omdb")
public class OMDBResource {
    private final OMDBService omdbService;

    public OMDBResource(OMDBService omdbService) {
        this.omdbService = omdbService;
    }

    @GetMapping("/series/{title}")
    public OMDBSerieDTO getOMDBSerie(@PathVariable String title) {
        String plot = "full";
        return omdbService.getSerie(title, plot);
    }

    @GetMapping("/movies/{title}")
    public OMDBMovieDTO getOMDBMovie(@PathVariable String title) {
        String plot = "full";
        return omdbService.getMovie(title, plot);
    }
}
