package com.mapToFiction.mapToFiction.resource;

import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.service.FictionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fictions")
public class FictionResource {
    private final FictionService fictionService;

    public FictionResource(FictionService fictionService) {
        this.fictionService = fictionService;
    }

    @GetMapping
    public List<Fiction> getAllFictions() {
        return fictionService.getAllFictions();
    }

    @GetMapping("/{id}")
    public Fiction getFictionById(@PathVariable String id) {
        return fictionService.getFictionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fiction createFiction(@RequestBody Fiction fiction) {
        return fictionService.createFiction(fiction);
    }

    @PutMapping("/{id}")
    public Fiction updateFiction(@PathVariable String id, @RequestBody Fiction fiction) {
        return fictionService.updateFiction(fiction);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFiction(@PathVariable String id) {
        fictionService.deleteFiction(id);
    }
}
