package com.fiktionmaps.fiktionmaps.repository;

import com.fiktionmaps.fiktionmaps.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT l FROM Location l WHERE l.formattedAddress = :address")
    Location findByAddress(String address);

    @Query("SELECT p FROM Location p WHERE p.placeId = :placeId")
    Optional<Location> findByPlaceId(String placeId);

    @Query("SELECT count(p) FROM Place p WHERE p.location.id = :locationId")
    int countPlacesByLocation(@Param("locationId") Long locationId);
}
