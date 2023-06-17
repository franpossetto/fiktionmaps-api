package com.mapToFiction.mapToFiction.repository;
import com.mapToFiction.mapToFiction.model.RowAPIData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowAPIDataRepository extends JpaRepository<RowAPIData, Long> {
}
