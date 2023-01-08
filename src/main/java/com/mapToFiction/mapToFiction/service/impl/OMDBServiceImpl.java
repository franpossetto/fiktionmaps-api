package com.mapToFiction.mapToFiction.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapToFiction.mapToFiction.model.dto.omdb.OMDBFiction;
import com.mapToFiction.mapToFiction.model.dto.omdb.OMDBMovieDTO;
import com.mapToFiction.mapToFiction.model.dto.omdb.OMDBSerieDTO;
import com.mapToFiction.mapToFiction.service.OMDBService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OMDBServiceImpl implements OMDBService {

    private static final String URL =  "http://www.omdbapi.com/?apikey={key}&t={title}&plot={plot}&type={type}";
    private final RestTemplate restTemplate;
    @Value("${OMDB_API_KEY}")
    private String API_KEY;

    public OMDBServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OMDBSerieDTO getSerie(String title, String plot) {
        String type = "series";
        String url = URL.replace("{title}", title).replace("{key}", API_KEY).replace("{plot}", plot).replace("{type}", type);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(response.getBody());
            OMDBSerieDTO result = mapper.treeToValue(root, OMDBSerieDTO.class);
            return result;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public OMDBMovieDTO getMovie(String title, String plot) {
        String type = "movie";
        String url = URL.replace("{title}", title).replace("{key}", API_KEY).replace("{plot}", plot).replace("{type}", type);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(response.getBody());
            OMDBMovieDTO result = mapper.treeToValue(root, OMDBMovieDTO.class);
            return result;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
