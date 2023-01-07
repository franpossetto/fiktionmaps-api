package com.mapToFiction.mapToFiction.repository;

import com.mapToFiction.mapToFiction.model.Map;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, Long> {
}
