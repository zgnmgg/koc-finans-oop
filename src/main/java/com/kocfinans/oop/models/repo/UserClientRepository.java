package com.kocfinans.oop.models.repo;

import com.kocfinans.oop.models.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserClientRepository extends JpaRepository<UserClient, Integer> {

    Optional<UserClient> findOneByEmail(
            String email);

    Optional<UserClient> findOneById(
            int id);

    boolean existsByEmail(String email);
}
