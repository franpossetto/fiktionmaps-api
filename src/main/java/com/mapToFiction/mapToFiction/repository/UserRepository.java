package com.mapToFiction.mapToFiction.repository;

import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByExternalUserId(String externalUserId);

}
