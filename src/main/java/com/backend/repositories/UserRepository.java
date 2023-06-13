package com.backend.repositories;

import com.backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends
        JpaRepository<Users, Integer> {
    Optional<Users> findUsersByEmail(String email);
}
