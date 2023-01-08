package com.mapToFiction.mapToFiction.service;


import com.mapToFiction.mapToFiction.model.dto.omdb.OMDBFiction;
import com.mapToFiction.mapToFiction.model.dto.omdb.OMDBMovieDTO;
import com.mapToFiction.mapToFiction.model.dto.omdb.OMDBSerieDTO;

public interface OMDBService {
    OMDBSerieDTO getSerie(String title, String plot);
    OMDBMovieDTO getMovie(String title, String plot);

}
