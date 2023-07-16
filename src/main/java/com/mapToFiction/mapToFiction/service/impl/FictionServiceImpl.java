package com.mapToFiction.mapToFiction.service.impl;
import com.mapToFiction.mapToFiction.mapper.CityMapper;
import com.mapToFiction.mapToFiction.mapper.FictionMapper;
import com.mapToFiction.mapToFiction.mapper.LocationMapper;
import com.mapToFiction.mapToFiction.mapper.SceneMapper;
import com.mapToFiction.mapToFiction.model.*;
import com.mapToFiction.mapToFiction.repository.*;
import com.mapToFiction.mapToFiction.service.FictionService;
import com.mapToFiction.mapToFiction.service.dto.CityDTO;
import com.mapToFiction.mapToFiction.service.dto.FictionDTO;
import com.mapToFiction.mapToFiction.service.dto.LocationDTO;
import com.mapToFiction.mapToFiction.service.dto.SceneDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FictionServiceImpl implements FictionService {
    private final FictionRepository fictionRepository;
    private final SceneRepository sceneRepository;
    private final LocationRepository locationRepository;
    private final CityRepository cityRepository;

    private final UserRepository userRepository;
    private final FictionMapper fictionMapper;
    private final SceneMapper sceneMapper;
    private final LocationMapper locationMapper;
    private final CityMapper cityMapper;
    public FictionServiceImpl(FictionRepository fictionRepository, SceneRepository sceneRepository, LocationRepository locationRepository, UserRepository userRepository, CityRepository cityRepository, FictionMapper fictionMapper, SceneMapper sceneMapper, LocationMapper locationMapper, CityMapper cityMapper) {
        this.fictionRepository = fictionRepository;
        this.sceneRepository = sceneRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.cityRepository = cityRepository;
        this.fictionMapper = fictionMapper;
        this.sceneMapper = sceneMapper;
        this.locationMapper = locationMapper;
        this.cityMapper = cityMapper;

    }

    @Override
    public List<FictionDTO> getAll() {
        List<Fiction> fictions = fictionRepository.findAll();
        return fictionMapper.toDtoList(fictions);
    }

    @Override
    public Fiction getById(Long id) {
        return fictionRepository.findById(id).orElse(null);
    }


    @Override
    public FictionDTO create(FictionDTO fictionDto) {
        Fiction fiction = fictionMapper.toEntity(fictionDto);
        Fiction savedFiction = fictionRepository.save(fiction);
        return fictionMapper.toDto(savedFiction);
    }

    @Override
    public Fiction update(Fiction fiction) {
        return fictionRepository.save(fiction);
    }

    @Override
    public Fiction update(Long id, Fiction fiction) {
        return fictionRepository.findById(id)
                .map(f -> {
                    f.setName(fiction.getName());
                    f.setType(fiction.getType());
                    f.setScenes(fiction.getScenes());
                    return fictionRepository.save(fiction);
                })
                .orElseThrow(() -> new IllegalArgumentException("Fiction not found with id " + id));
    }

    @Override
    public Fiction findByName(String name) {
        return fictionRepository.findByName(name);
    }

    @Override
    public FictionDTO addScene(Long id, SceneDTO sceneDto){

        Optional<Fiction> fictionOpt = fictionRepository.findById(id);
        if (!fictionOpt.isPresent()) {
            throw new NoSuchElementException("No Fiction found with id " + id);
        }
        Fiction fiction = fictionOpt.get();

        Optional<User> userOpt = userRepository.findById(sceneDto.getUser_id());
        if (!userOpt.isPresent()) {
            throw new NoSuchElementException("No User found with id " + sceneDto.getUser_id());
        }
        User user = userOpt.get();

        Scene scene = sceneMapper.toEntity(sceneDto);
        scene.setFiction(fiction);
        scene.setUser(user);
        sceneRepository.save(scene);

        return fictionMapper.toDto(fiction);
    }

    @Override
    public SceneDTO addLocationToScene(Long fictionId, Long sceneId, LocationDTO locationDto) {
        Optional<Fiction> fictionOpt = fictionRepository.findById(fictionId);
        if (!fictionOpt.isPresent()) {
            throw new NoSuchElementException("No Fiction found with id " + fictionId);
        }

        Scene scene = sceneRepository.findById(sceneId).get();

        if(scene.getLocation() != null){
            throw new IllegalStateException("The scene already has a location");
        }

        // Checking if a location with the given placeId already exists
        Optional<Location> existingLocation = locationRepository.findByPlaceId(locationDto.getPlace_id());

        Location location;
        if(existingLocation.isPresent()) {
            // If a location with the given placeId exists, we use it
            location = existingLocation.get();
        } else {
            // If no such location exists, we create a new one
            location = locationMapper.toEntity(locationDto);
            Long cityId = locationDto.getCity_id();
            Optional<City> cityOpt = cityRepository.findById(cityId);
            if (cityOpt.isPresent()) {
                location.setCity(cityOpt.get());
            }

            locationRepository.save(location);
        }

        scene.setLocation(location);

        sceneRepository.save(scene);
        return sceneMapper.toDto(scene);
    }


    @Override
    public void deleteFiction(Long id){
        fictionRepository.deleteById(id);
    }

    @Override
    public boolean exists(String name) {
        return fictionRepository.existsByName(name);
    }
    @Override
    public List<FictionDTO> getFictionsByCity(Long cityId) {
        List<Fiction> fictions = fictionRepository.findByCityId(cityId);
        return fictions.stream()
                .map(fictionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDTO> getCitiesByFiction(Long fictionId){
        return cityMapper.toDtoList(fictionRepository.getCitiesByFiction(fictionId));
    }

}