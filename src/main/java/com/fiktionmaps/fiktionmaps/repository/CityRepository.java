package com.fiktionmaps.fiktionmaps.repository;

import com.fiktionmaps.fiktionmaps.model.City;
import com.fiktionmaps.fiktionmaps.service.dto.CityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT c.id, COUNT(p) FROM City c " +
            "JOIN c.locations l " +
            "JOIN l.places p " +
            "GROUP BY c.id")
    List<Object[]> countPlacesInCities();
}
