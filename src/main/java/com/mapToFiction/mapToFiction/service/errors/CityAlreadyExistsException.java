package com.mapToFiction.mapToFiction.service.errors;

public class CityAlreadyExistsException extends RuntimeException {
    private static final String CITY_ALREADY_EXISTS = "The city already exists";
    public CityAlreadyExistsException() {
        super(CITY_ALREADY_EXISTS);
    }
}

