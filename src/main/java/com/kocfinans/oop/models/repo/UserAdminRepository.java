package com.kocfinans.oop.models.repo;

import com.kocfinans.oop.models.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Integer> {

    Optional<UserAdmin> findOneByEmail(
            String email);

    boolean existsByEmail(String email);
}

