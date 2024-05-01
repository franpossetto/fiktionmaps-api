package com.fiktionmaps.fiktionmaps.repository;

import com.fiktionmaps.fiktionmaps.model.Place;
import com.fiktionmaps.fiktionmaps.service.dto.PlaceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Collectors;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Page<Place> getPlacesByUserId(Long userId, Pageable pageable);

    @Query("SELECT p FROM Place p WHERE p.published = true")
    Page<Place> findByPublished(Pageable pageable);

    @Query("SELECT p FROM Place p WHERE p.published = false OR p.published IS NULL")
    Page<Place> findByNotPublished(Pageable pageable);

    @Query("SELECT p FROM Place p WHERE p.published = true")
    List<Place> findPlacesByFictionAndLocation(Long fictionId,
                                               Double leftLatitude,
                                               Double rightLatitude,
                                               Double topLongitude,
                                               Double bottomLongitude);



}