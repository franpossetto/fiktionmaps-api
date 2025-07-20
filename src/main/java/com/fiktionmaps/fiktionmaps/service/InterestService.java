package com.fiktionmaps.fiktionmaps.service;

import com.fiktionmaps.fiktionmaps.service.dto.InterestDTO;

import java.util.List;

public interface InterestService {
    
    InterestDTO add(Long userId, Long fictionId);
    
    void remove(Long userId, Long fictionId);
    
    List<InterestDTO> findByUser(Long userId);
    
    List<InterestDTO> findByFiction(Long fictionId);
    
    Long count(Long fictionId);
    
    Long countByUser(Long userId);
    
    boolean exists(Long userId, Long fictionId);
} 