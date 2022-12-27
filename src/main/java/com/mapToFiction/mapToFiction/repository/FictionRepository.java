package com.mapToFiction.mapToFiction.repository;

import com.mapToFiction.mapToFiction.model.Fiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FictionRepository extends JpaRepository<Fiction, String> {
}
