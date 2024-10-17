package com.fiktionmaps.fiktionmaps.service;

import com.fiktionmaps.fiktionmaps.dto.PlaceByAreaRequestDTO;
import com.fiktionmaps.fiktionmaps.model.Fiction;
import com.fiktionmaps.fiktionmaps.model.Place;
import com.fiktionmaps.fiktionmaps.service.dto.PlaceDTO;

import java.util.List;

public interface PlaceService {
    PlaceDTO create(PlaceDTO placeDTO, Fiction fiction);

    PlaceDTO update(Long id, PlaceDTO placeDto);

    void delete(Long id);

    PlaceDTO getById(Long id);

    List<PlaceDTO> getAll();

    List<PlaceDTO> getPlacesbyUserId(Long userId);
    List<PlaceDTO> getMyPlacesNotApproved();

    PlaceDTO approve(Long id, Long cityId);
    List<PlaceDTO> getPlacesByFictionAndLocation(Long fictionId,
                                                 Double leftLatitude,
                                                 Double rightLatitude,
                                                 Double topLongitude,
                                                 Double bottomLongitude);

    List<Place> findByArea(PlaceByAreaRequestDTO placeByAreaRequestDTO);
}
