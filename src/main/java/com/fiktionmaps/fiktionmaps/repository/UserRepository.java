package com.fiktionmaps.fiktionmaps.repository;

import com.fiktionmaps.fiktionmaps.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByExternalUserId(String externalUserId);
}
