package com.mapToFiction.mapToFiction.repository;

import com.mapToFiction.mapToFiction.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
