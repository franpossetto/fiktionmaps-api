package com.mapToFiction.mapToFiction.service.errors;

public class CityErrorHandler {
    public static void handleError(CityErrorEnum error) {
        switch (error) {
            case OK:
                break;
            case CITY_ALREADY_EXISTS:
                throw new CityAlreadyExistsException();
            case ZERO_RESULTS:
                break;
            case INVALID_REQUEST:
                break;
            case UNKNOWN_ERROR:
                break;
        }
    }
}
