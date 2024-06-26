package com.fiktionmaps.fiktionmaps.resource;

import com.fiktionmaps.fiktionmaps.config.JwtService;
import com.fiktionmaps.fiktionmaps.mapper.FictionMapper;
import com.fiktionmaps.fiktionmaps.model.Fiction;
import com.fiktionmaps.fiktionmaps.service.FictionService;
import com.fiktionmaps.fiktionmaps.service.PlaceService;
import com.fiktionmaps.fiktionmaps.service.UserService;
import com.fiktionmaps.fiktionmaps.service.dto.FictionDTO;
import com.fiktionmaps.fiktionmaps.service.dto.PlaceDTO;
import com.fiktionmaps.fiktionmaps.service.impl.UserServiceImpl;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/fictions")
public class FictionResource {

    private final FictionService fictionService;
    private final PlaceService placeService;
    private final FictionMapper fictionMapper;

    private final UserService userService;

    public FictionResource(FictionService fictionService, PlaceService placeService, FictionMapper fictionMapper, UserService userService) {
        this.fictionService = fictionService;
        this.placeService = placeService;
        this.fictionMapper = fictionMapper;
        this.userService = userService;
    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<FictionDTO>> getFictions() {
        List<FictionDTO> fictionDTOs = fictionService.getAll();

        if (fictionDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(fictionDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FictionDTO> getFictionById(@PathVariable Long id){
        Fiction fiction = fictionService.findById(id);
        return new ResponseEntity<>(fictionMapper.toDto(fiction), HttpStatus.OK);
    }

    @GetMapping("/cities/{cityId}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<FictionDTO>> getFictionsByCityId(@PathVariable Long cityId) {
        List<FictionDTO> fictionDTOs = fictionService.getFictionsByCity(cityId);
        return new ResponseEntity<>(fictionDTOs, HttpStatus.OK);
    }

    @PostMapping("/{id}/places")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PlaceDTO> addPlaceToFiction(@RequestHeader("Authorization") String token, @PathVariable Long id, @RequestBody PlaceDTO placeDTO) {

        Long userId = userService.getUserFromToken(token).getId();
        placeDTO.setUserId(userId);
        Fiction fiction = fictionService.findById(id);
        PlaceDTO createdPlace = placeService.create(placeDTO, fiction);
        return ResponseEntity.ok(createdPlace);
    }

    @GetMapping("/places/{fictionId}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PlaceDTO>> getPlacesByLatitudeAndLongitude(
            @PathVariable Long fictionId,
            @RequestParam Double leftLatitude,
            @RequestParam Double rightLatitude,
            @RequestParam Double topLongitude,
            @RequestParam Double bottomLongitude) {

            List<PlaceDTO> result = placeService.getPlacesByFictionAndLocation(fictionId, leftLatitude, rightLatitude, topLongitude, bottomLongitude);
            return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
