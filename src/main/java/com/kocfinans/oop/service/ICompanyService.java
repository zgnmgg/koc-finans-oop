package com.kocfinans.oop.service;

import com.kocfinans.oop.models.Company;
import com.kocfinans.oop.models.dto.CompanyDTO;

public interface ICompanyService {

    Company getCompanyById(int id);
    Company create(CompanyDTO dto);
}
