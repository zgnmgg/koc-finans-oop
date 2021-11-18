package com.kocfinans.oop.models.repo;

import com.kocfinans.oop.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findOneByIdAndEnableTrue(
            int id);
}
