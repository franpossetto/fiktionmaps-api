package com.fiktionmaps.fiktionmaps.resource;

import com.fiktionmaps.fiktionmaps.service.InterestService;
import com.fiktionmaps.fiktionmaps.service.UserService;
import com.fiktionmaps.fiktionmaps.service.dto.InterestDTO;
import com.fiktionmaps.fiktionmaps.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/interests")
public class InterestResource {

    private final InterestService interestService;
    private final UserService userService;

    public InterestResource(InterestService interestService, UserService userService) {
        this.interestService = interestService;
        this.userService = userService;
    }

    @PostMapping("/fictions/{fictionId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<InterestDTO> addInterest(@RequestHeader("Authorization") String token, 
                                                  @PathVariable Long fictionId) {
        try {
            UserDTO user = userService.getUserFromToken(token);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            InterestDTO result = interestService.add(user.getId(), fictionId);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (IllegalStateException | IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/fictions/{fictionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> removeInterest(@RequestHeader("Authorization") String token,
                                              @PathVariable Long fictionId) {
        try {
            UserDTO user = userService.getUserFromToken(token);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            interestService.remove(user.getId(), fictionId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/fictions")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<InterestDTO>> getInterests(@RequestParam(required = false) Long userId, 
                                                         @RequestParam(required = false) Long fictionId,
                                                         @RequestHeader(value = "Authorization", required = false) String token) {
        if (userId != null) {
            // Public endpoint - get interests of specific user
            List<InterestDTO> interests = interestService.findByUser(userId);
            return new ResponseEntity<>(interests, HttpStatus.OK);
        } else if (fictionId != null) {
            // Public endpoint - get interests for specific fiction
            List<InterestDTO> interests = interestService.findByFiction(fictionId);
            return new ResponseEntity<>(interests, HttpStatus.OK);
        } else {
            // Private endpoint - get my interests (requires auth)
            if (token == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            try {
                UserDTO user = userService.getUserFromToken(token);
                if (user == null) {
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }
                List<InterestDTO> interests = interestService.findByUser(user.getId());
                return new ResponseEntity<>(interests, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
    }
} 