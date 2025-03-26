package com.fiktionmaps.fiktionmaps.repository;

import com.fiktionmaps.fiktionmaps.model.City;
import com.fiktionmaps.fiktionmaps.model.Fiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FictionRepository extends JpaRepository<Fiction, Long> {
    @Query("SELECT f FROM Fiction f WHERE f.name = :name")
    Fiction findByName(String name);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Fiction c WHERE c.name = :name")
    boolean existsByName(String name);

    @Query("SELECT DISTINCT f FROM Fiction f JOIN f.places p WHERE p.location.city.id = :cityId")
    List<Fiction> findByCityId(@Param("cityId") Long fictionId);

    @Query("SELECT DISTINCT f FROM Fiction f JOIN f.places p WHERE p.location.latitude BETWEEN :lowerLat AND :upperLat AND p.location.longitude BETWEEN :leftLng AND :rightLng")
    List<Fiction> findByCoordinatesBetween(@Param("lowerLat") double lowerLat, 
                                         @Param("upperLat") double upperLat, 
                                         @Param("leftLng") double leftLng, 
                                         @Param("rightLng") double rightLng);
}
