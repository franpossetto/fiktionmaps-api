package com.mapToFiction.mapToFiction.service;

import com.mapToFiction.mapToFiction.model.dto.gmaps.ResultsDTO;

public interface GoogleMapsService {

    // Get Place

    // Get Lat
    ResultsDTO getPlace(String address);
}
