package com.mapToFiction.mapToFiction.repository;

import com.mapToFiction.mapToFiction.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
