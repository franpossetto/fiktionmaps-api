package com.fiktionmaps.fiktionmaps.resource;

import com.fiktionmaps.fiktionmaps.mapper.FictionMapper;
import com.fiktionmaps.fiktionmaps.model.Fiction;
import com.fiktionmaps.fiktionmaps.service.FictionService;
import com.fiktionmaps.fiktionmaps.service.PlaceService;
import com.fiktionmaps.fiktionmaps.service.dto.FictionDTO;
import com.fiktionmaps.fiktionmaps.service.dto.PlaceDTO;
import com.google.errorprone.annotations.Var;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fictions")
public class FictionResource {

    private final FictionService fictionService;
    private final PlaceService placeService;

    private final FictionMapper fictionMapper;

    public FictionResource(FictionService fictionService, PlaceService placeService, FictionMapper fictionMapper) {
        this.fictionService = fictionService;
        this.placeService = placeService;
        this.fictionMapper = fictionMapper;
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
    @GetMapping("/{cityId}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<FictionDTO>> getFictionsByCityId(@PathVariable Long cityId) {
        List<FictionDTO> fictionDTOs = fictionService.getFictionsByCity(cityId);

        if (fictionDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(fictionDTOs, HttpStatus.OK);
    }

    @PostMapping("/{id}/places")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PlaceDTO> addPlaceToFiction(@PathVariable Long id, @RequestBody PlaceDTO placeDTO){
        Fiction fiction = fictionService.findById(id);
        PlaceDTO createdPlace = placeService.create(placeDTO, fiction);
        return ResponseEntity.ok(createdPlace);
    }
}
