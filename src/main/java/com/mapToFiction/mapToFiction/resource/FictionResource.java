package com.mapToFiction.mapToFiction.resource;

import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.service.FictionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fictions")
public class FictionResource {
    private final FictionService fictionService;
    public FictionResource(FictionService fictionService) {
        this.fictionService = fictionService;
    }

    @GetMapping
    @Transactional
    public List<Fiction> getAllFictions() {
        return fictionService.getAll();
    }

    @GetMapping("/{id}")
    public Fiction getFictionById(@PathVariable Long id) {
        return fictionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fiction createFiction(@RequestBody Fiction fiction) {
        return fictionService.create(fiction);
    }

    @PutMapping("/{id}")
    public Fiction updateFiction(@PathVariable String id, @RequestBody Fiction fiction) {
        return fictionService.update(fiction);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFiction(@PathVariable Long id) {
        fictionService.delete(id);
    }
}
