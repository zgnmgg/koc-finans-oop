package com.kocfinans.oop.models.repo;

import com.kocfinans.oop.models.Company;
import com.kocfinans.oop.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findAllByCompany(Company company);

    Optional<Menu> findOneByIdAndCompany(int id, Company company);

    Optional<Menu> findOneById(int id);

    void deleteByCompanyAndId(
            Company company,
            int id
    );
}

