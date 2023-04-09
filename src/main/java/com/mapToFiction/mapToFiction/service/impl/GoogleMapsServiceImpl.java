package com.mapToFiction.mapToFiction.service.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapToFiction.mapToFiction.model.dto.gmaps.ResultsDTO;
import com.mapToFiction.mapToFiction.service.GoogleMapsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleMapsServiceImpl implements GoogleMapsService {
    private static final String GEOCODING_URL = "https://maps.googleapis.com/maps/api/geocode/json?address={address}&types=address&key={key}";
    private final RestTemplate restTemplate;
    @Value("${GOOGLE_MAPS_API_KEY}")
    private String API_KEY ;

    public GoogleMapsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResultsDTO getPlace(String address) {
        String url = GEOCODING_URL.replace("{address}", address).replace("{key}", API_KEY);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        try {
            JsonNode root = mapper.readTree(response.getBody());
            ResultsDTO result = mapper.treeToValue(root.get("results").get(0), ResultsDTO.class);
            return result;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
