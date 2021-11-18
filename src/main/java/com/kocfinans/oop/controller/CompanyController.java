package com.kocfinans.oop.controller;

import com.kocfinans.oop.models.Company;
import com.kocfinans.oop.models.dto.CompanyDTO;
import com.kocfinans.oop.service.ICompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Qualifier("CompanyController")
@RequestMapping("/company")
public class CompanyController {

    private final ICompanyService service;

    @PostMapping("")
    public ResponseEntity<Company> createCompany(
            @RequestBody @Valid CompanyDTO companyDTO) {
        return ResponseEntity.ok().body(this.service.create(companyDTO));
    }
}
