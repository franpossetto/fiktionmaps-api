package com.mapToFiction.mapToFiction.service;

import com.mapToFiction.mapToFiction.model.dto.gmaps.ResultsDTO;

public interface GoogleMapsService {
    ResultsDTO getPlace(String address);
}
