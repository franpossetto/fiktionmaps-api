package com.fiktionmaps.fiktionmaps.resource;

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

//    @GetMapping
//    @CrossOrigin
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<PlaceDTO>> getPlaces(){
//        List<Place> places = placeRepository.findAll();
//        return new ResponseEntity<>(placeMapper.toDtoList(places), HttpStatus.OK);
//    }

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
