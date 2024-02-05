package com.fiktionmaps.fiktionmaps.repository;

import com.fiktionmaps.fiktionmaps.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> getPlacesByUserId(Long userId);

    @Query("SELECT p FROM Place p WHERE p.published = true")
    List<Place> findByPublished();

    @Query("SELECT p FROM Place p WHERE p.published = false OR p.published IS NULL")
    List<Place> findByNotPublished();

}
