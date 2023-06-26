package com.mapToFiction.mapToFiction.repository;

import com.mapToFiction.mapToFiction.model.Fiction;
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
    @Query("SELECT DISTINCT f FROM Fiction f JOIN f.scenes s WHERE s.location.city.id = :cityId")
    List<Fiction> findByCityId(@Param("cityId") Long cityId);

}
