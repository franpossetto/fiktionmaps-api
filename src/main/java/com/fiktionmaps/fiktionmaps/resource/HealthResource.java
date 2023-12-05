package com.fiktionmaps.fiktionmaps.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HealthResource {
    public HealthResource() {

    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> HealthCheck() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/healthCheck")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> HealthCheckTest() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/healthCheck2")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> HealthCheckTest2() {
        return ResponseEntity.ok().build();
    }

}
