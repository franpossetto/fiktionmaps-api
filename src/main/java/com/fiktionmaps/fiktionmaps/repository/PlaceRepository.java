package com.fiktionmaps.fiktionmaps.repository;

import com.fiktionmaps.fiktionmaps.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
