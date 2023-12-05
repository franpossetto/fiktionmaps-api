package com.fiktionmaps.fiktionmaps.resource;

import com.fiktionmaps.fiktionmaps.service.FictionService;
import com.fiktionmaps.fiktionmaps.service.dto.FictionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fictions")
public class FictionResource {

    private final FictionService fictionService;

    public FictionResource(FictionService fictionService) {
        this.fictionService = fictionService;
    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<FictionDTO>> getFictions(@RequestParam(required = false) Long cityId) {
        if (cityId != null) {
            return fictionService.getFictionsByCity(cityId);
        } else {
            return fictionService.getAll();
        }
    }

}
