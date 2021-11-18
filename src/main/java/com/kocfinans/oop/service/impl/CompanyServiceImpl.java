package com.kocfinans.oop.service.impl;

import com.kocfinans.oop.exception.CompanyNotFoundException;
import com.kocfinans.oop.models.Company;
import com.kocfinans.oop.models.dto.CompanyDTO;
import com.kocfinans.oop.models.repo.CompanyRepository;
import com.kocfinans.oop.service.ICompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    /**
     * Get a company by id
     *
     * @param id: int
     *
     * @return Company
     *
     * @throws CompanyNotFoundException - if Company not Found
     *
     */
    public Company getCompanyById(int id) {
        return this.repository.findOneByIdAndEnableTrue(
                id
        ).orElseThrow(CompanyNotFoundException::new);
    }

    /**
     * Create a company
     *
     * @param dto: CompanyDTO
     *
     * @return Company
     */
    @Transactional
    public Company create(CompanyDTO dto) {
        Company company = new Company();
        company.setChangeableAttributes(dto);
        company.setUnchangeableAttributes();

        return this.save(company);
    }

    /**
     * Save company
     *
     * @param company: Company
     *
     * @return Company
     */
    private Company save(Company company) {
        return this.repository.save(company);
    }
}
