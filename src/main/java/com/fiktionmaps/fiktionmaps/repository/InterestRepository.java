package com.fiktionmaps.fiktionmaps.repository;

import com.fiktionmaps.fiktionmaps.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

    @Query("SELECT i FROM Interest i WHERE i.user.id = :userId")
    List<Interest> findByUserId(@Param("userId") Long userId);

    @Query("SELECT i FROM Interest i WHERE i.fiction.id = :fictionId")
    List<Interest> findByFictionId(@Param("fictionId") Long fictionId);

    @Query("SELECT i FROM Interest i WHERE i.user.id = :userId AND i.fiction.id = :fictionId")
    Optional<Interest> findByUserIdAndFictionId(@Param("userId") Long userId, @Param("fictionId") Long fictionId);

    @Query("SELECT COUNT(i) FROM Interest i WHERE i.fiction.id = :fictionId")
    Long countByFictionId(@Param("fictionId") Long fictionId);

    @Query("SELECT COUNT(i) FROM Interest i WHERE i.user.id = :userId")
    Long countByUserId(@Param("userId") Long userId);

    boolean existsByUserIdAndFictionId(Long userId, Long fictionId);
} 