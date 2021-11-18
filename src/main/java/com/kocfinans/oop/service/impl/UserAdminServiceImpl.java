package com.kocfinans.oop.service.impl;

import com.kocfinans.oop.exception.UserAdminAlreadyExistsException;
import com.kocfinans.oop.exception.UserAdminNotEnableException;
import com.kocfinans.oop.exception.UserAdminNotFoundException;
import com.kocfinans.oop.models.UserAdmin;
import com.kocfinans.oop.models.dto.UserAdminDTO;
import com.kocfinans.oop.models.repo.UserAdminRepository;
import com.kocfinans.oop.service.ICompanyService;
import com.kocfinans.oop.service.IUserAdminService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAdminServiceImpl implements IUserAdminService {

    // Repositories
    private final UserAdminRepository repository;

    // Services
    private final ICompanyService companyService;

    // Utilities
    private final PasswordEncoder passwordEncoder;

    public UserAdminServiceImpl(UserAdminRepository repository, CompanyServiceImpl companyService, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.companyService = companyService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Get user admin by email
     *
     * @param email: String
     *
     * @return UserAdmin
     *
     * @throws UserAdminNotFoundException - if UserAdmin not found
     */
    public UserAdmin getUserAdminByEmail(String email) {
        return this.repository.findOneByEmail(
                email
        ).orElseThrow(UserAdminNotFoundException::new);
    }

    /**
     * Get enable user admin by email
     *
     * @param email: String
     *
     * @return UserAdmin
     *
     * @throws UserAdminNotEnableException - if UserAdmin is not enable
     */
    public UserAdmin getUserAdminByEmailAndEnable(String email) {
        UserAdmin userAdmin = this.getUserAdminByEmail(email);
        if (!userAdmin.isEnable()) throw new UserAdminNotEnableException();
        return userAdmin;
    }

    /**
     * Create a user admin
     *
     * @param uaDTO: UserAdminDTO
     * @param companyId: int
     *
     * @return UserAdmin
     */
    @Transactional
    public UserAdmin create(UserAdminDTO uaDTO, int companyId) {
        this.checkByEmail(uaDTO.getEmail());
        uaDTO.setPassword(this.passwordEncoder.encode(uaDTO.getPassword()));
        UserAdmin userAdmin = new UserAdmin();
        userAdmin.setCompany(this.companyService.getCompanyById(companyId));
        userAdmin.setUnchangeableAttributes(uaDTO);
        userAdmin.setChangeableAttributes(uaDTO);

        return this.save(userAdmin);
    }

    /**
     * Exists User Admin By email if it is exists throw exception
     *
     * @param email: String
     *
     * @throws UserAdminAlreadyExistsException - if UserAdmin already exists
     */
    private void checkByEmail(String email) {
        if(this.repository.existsByEmail(email)){
            throw new UserAdminAlreadyExistsException();
        }
    }

    /**
     * Save user admin
     *
     * @param ua: UserAdmin
     *
     * @return UserAdmin
     */
    private UserAdmin save(UserAdmin ua) {
        return this.repository.save(ua);
    }
}
