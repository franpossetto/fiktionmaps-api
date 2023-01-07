package com.mapToFiction.mapToFiction.service.impl;

import com.mapToFiction.mapToFiction.model.City;
import com.mapToFiction.mapToFiction.model.dto.gmaps.ResultsDTO;
import com.mapToFiction.mapToFiction.repository.CityRepository;
import com.mapToFiction.mapToFiction.service.CityService;
import com.mapToFiction.mapToFiction.service.GoogleMapsService;
import com.mapToFiction.mapToFiction.service.errors.CityErrorEnum;
import com.mapToFiction.mapToFiction.service.errors.CityErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{

    public final CityRepository cityRepository;
    public final GoogleMapsService googleMapsService;

    public CityServiceImpl(CityRepository cityRepository, GoogleMapsService googleMapsService) {
        this.cityRepository = cityRepository;
        this.googleMapsService = googleMapsService;
    }

    @Override
    public ResponseEntity<Void> add(String cityData) {
        try {
            ResultsDTO resultsDto = googleMapsService.getPlace(cityData);
            City city = new City(resultsDto.formattedAddress,"country", resultsDto.placeId, City.Provider.GOOGLE_MAPS);
            cityRepository.save(city);
            return ResponseEntity.ok().build();
        } catch(Error e) {
             CityErrorHandler.handleError(CityErrorEnum.CITY_ALREADY_EXISTS);
            return ResponseEntity.badRequest().build();
        }
    }
}
