package com.fiktionmaps.fiktionmaps.service.impl;

import com.fiktionmaps.fiktionmaps.mapper.LocationMapper;
import com.fiktionmaps.fiktionmaps.mapper.PlaceMapper;
import com.fiktionmaps.fiktionmaps.model.*;
import com.fiktionmaps.fiktionmaps.repository.LocationRepository;
import com.fiktionmaps.fiktionmaps.repository.PlaceRepository;
import com.fiktionmaps.fiktionmaps.service.PlaceService;
import com.fiktionmaps.fiktionmaps.service.dto.FictionDTO;
import com.fiktionmaps.fiktionmaps.service.dto.LocationDTO;
import com.fiktionmaps.fiktionmaps.service.dto.PlaceDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {
    private PlaceRepository placeRepository;
    private PlaceMapper placeMapper;
    private LocationMapper locationMapper;
    private LocationRepository locationRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository, PlaceMapper placeMapper, LocationMapper locationMapper, LocationRepository locationRepository){
        this.placeRepository=placeRepository;
        this.placeMapper=placeMapper;
        this.locationMapper=locationMapper;
        this.locationRepository=locationRepository;
    }


    @Override
    @Transactional
    public PlaceDTO create(PlaceDTO dto, Fiction fic) {
        Place place = placeMapper.toEntity(dto);

        if (fic != null) {
            place.setFiction(fic);
        }

        Location loc = handleLocation(dto.getLocation());
        place.setLocation(loc);

        if (dto.getUserId() != null) {
            setUser(place, dto.getUserId());
        }

        return placeMapper.toDto(placeRepository.save(place));
    }

    private Location handleLocation(LocationDTO locDto) {
        return locationRepository.findByPlaceId(locDto.getPlaceId())
                .orElseGet(() -> locationRepository.save(locationMapper.toEntity(locDto)));
    }

    private void setUser(Place p, Long userId) {
        User u = new User();
        u.setId(userId);
        p.setUser(u);
    }

    @Override
    public PlaceDTO update(Long id, PlaceDTO placeDTO) {
        Place place = placeRepository.findById(id).orElseThrow(() -> new RuntimeException("Place not found with id " + id));
        place.setName(placeDTO.getName());
        place.setDescription(placeDTO.getDescription());
        place.setScreenshot(placeDTO.getScreenshot());
        place.setPublished(false);

        Optional<Location> providedLocation = locationRepository.findByPlaceId(placeDTO.getLocation().getPlaceId());
        if (providedLocation.isEmpty()) {
            providedLocation = Optional.ofNullable(locationMapper.toEntity(placeDTO.getLocation()));
        }

        place.setLocation(providedLocation.get());
        return placeMapper.toDto(placeRepository.save(place));
    }

    @Override
    public PlaceDTO approve(Long id, Long cityId) {
        Place place = placeRepository.findById(id).orElseThrow(() -> new RuntimeException("Place not found with id " + id));
        Location location = place.getLocation();

        if(location.getCity() == null){
            City city = new City();
            city.setId(cityId);
            location.setCity(city);
        }

        place.setLocation(location);
        place.setPublished(true);

        return placeMapper.toDto(placeRepository.save(place));
    }

    @Override
    @Transactional
    public void delete(Long placeId) {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new RuntimeException("Place no found"));

        Location location = place.getLocation();
        placeRepository.delete(place);

        if (location != null && locationRepository.countPlacesByLocation(location.getId()) == 0) {
            locationRepository.delete(location);
        }
    }

    @Override
    public PlaceDTO getById(Long id) {
        return placeRepository.findById(id)
                .map(placeMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Place not found with id: " + id));
    }

    @Override
    public List<PlaceDTO> getAll() {
        List<Place> places = placeRepository.findAll();
        return placeMapper.toDtoList(places);
    }

    @Override
    public List<PlaceDTO> getPlacesbyUserId(Long userId) {
        return null;
    }

    @Override
    public List<PlaceDTO> getMyPlacesNotApproved() {
        return null;
    }


}
