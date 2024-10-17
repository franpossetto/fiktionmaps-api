package com.fiktionmaps.fiktionmaps.resource;

import com.fiktionmaps.fiktionmaps.dto.PlaceByAreaRequestDTO;
import com.fiktionmaps.fiktionmaps.dto.PlaceByAreaResponseDTO;
import com.fiktionmaps.fiktionmaps.mapper.PlaceMapper;
import com.fiktionmaps.fiktionmaps.model.Place;
import com.fiktionmaps.fiktionmaps.repository.PlaceRepository;
import com.fiktionmaps.fiktionmaps.service.PlaceService;
import com.fiktionmaps.fiktionmaps.service.UserService;
import com.fiktionmaps.fiktionmaps.service.dto.PlaceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/places")
public class PlaceResource {

    private PlaceRepository placeRepository;

    private PlaceService placeService;

    private UserService userService;

    private PlaceMapper placeMapper;

    public PlaceResource(PlaceRepository placeRepository, PlaceMapper placeMapper, PlaceService placeService, UserService userService){
        this.placeRepository = placeRepository;
        this.placeMapper = placeMapper;
        this.placeService = placeService;
        this.userService = userService;
    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<PlaceDTO>> getFilteredPlaces(@RequestParam(required = false) Boolean approved,
                                                            @RequestParam(defaultValue = "0") Integer page,
                                                            @RequestParam(defaultValue = "10") Integer size) {
        Page<Place> places;

        if (approved != null) {
            Pageable pageable = PageRequest.of(page-1, size);
            if (approved) {
                places = placeRepository.findByPublished(pageable);
                return new ResponseEntity<>(places.map(placeMapper::toDto), HttpStatus.OK);
            } else {
                places = placeRepository.findByNotPublished(pageable);
                return new ResponseEntity<>(places.map(placeMapper::toDto), HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/map")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PlaceByAreaResponseDTO>> GetPlacesByArea(
            @RequestParam double upperLat,
            @RequestParam double lowerLat,
            @RequestParam double rightLng,
            @RequestParam double leftLng,
            @RequestParam(required = false) Long fictionId) {

        PlaceByAreaRequestDTO placeByAreaRequestDTO = new PlaceByAreaRequestDTO(upperLat, lowerLat, rightLng, leftLng, fictionId);

        List<Place> places = placeService.findByArea(placeByAreaRequestDTO);

        List<PlaceByAreaResponseDTO> responseDTOs = places.stream()
                .map(this::mapToPlaceByAreaResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);

    }

    private PlaceByAreaResponseDTO mapToPlaceByAreaResponseDTO(Place place) {
        PlaceByAreaResponseDTO responseDTO = new PlaceByAreaResponseDTO();
        responseDTO.setPlaceId(place.getId());
        responseDTO.setLatitude(place.getLocation().getLatitude());
        responseDTO.setLongitude(place.getLocation().getLongitude());
        return responseDTO;
    }

    @GetMapping("/user")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<PlaceDTO>> getPlacesByUser(@RequestHeader("Authorization") String token,
                                                          @RequestParam(defaultValue = "0") Integer page,
                                                          @RequestParam(defaultValue = "10") Integer size){

        Pageable pageable = PageRequest.of(page-1, size);
        Long userId = userService.getUserFromToken(token).getId();
        Page<Place> placePage = placeRepository.getPlacesByUserId(userId, pageable);

        return new ResponseEntity<>(placePage.map(placeMapper::toDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PlaceDTO> updatePlace(@PathVariable Long id,  @RequestBody PlaceDTO placeDTO){
        PlaceDTO place = placeService.update(id, placeDTO);
        return new ResponseEntity<>(place, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/approve")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> approvePlace(@RequestHeader("Authorization") String token, @PathVariable Long id, @RequestParam Long cityId) {
        PlaceDTO place = placeService.getById(id);
        Long currentUser = userService.getUserFromToken(token).getId();
        if(place == null || currentUser == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Place and user must exists");
        }
        if (currentUser.equals(place.getUserId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You cannot approve a place that you created.");
        } else {
            PlaceDTO p = placeService.approve(id, cityId);
            return ResponseEntity.ok(p);
        }
    }



}
