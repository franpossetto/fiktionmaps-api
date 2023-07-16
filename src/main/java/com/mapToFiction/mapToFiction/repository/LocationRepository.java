package com.mapToFiction.mapToFiction.repository;

import com.mapToFiction.mapToFiction.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT l FROM Location l WHERE l.formattedAddress = :address")
    Location findByAddress(String address);

    @Query("SELECT p FROM Location p WHERE p.placeId = :placeId")
    Optional<Location> findByPlaceId(String placeId);
}
