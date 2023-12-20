package com.fiktionmaps.fiktionmaps.repository;

import com.fiktionmaps.fiktionmaps.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
