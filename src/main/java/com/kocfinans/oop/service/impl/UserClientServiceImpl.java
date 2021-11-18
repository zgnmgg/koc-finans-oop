package com.kocfinans.oop.service.impl;

import com.kocfinans.oop.exception.UserClientAlreadyExistException;
import com.kocfinans.oop.exception.UserClientNotFoundException;
import com.kocfinans.oop.helper.Utils;
import com.kocfinans.oop.models.UserClient;
import com.kocfinans.oop.models.dto.UserClientDTO;
import com.kocfinans.oop.models.repo.UserClientRepository;
import com.kocfinans.oop.service.IUserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserClientServiceImpl implements IUserClientService {

    // Repositories
    private final UserClientRepository repository;

    // Utilities
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserClientServiceImpl(UserClientRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Get a user client by email
     *
     * @param email: String
     *
     * @return UserClient
     *
     * @throws UserClientNotFoundException - if UserClient is not found
     */
    public UserClient getUserClientByEmail(String email) {
        return this.repository.findOneByEmail(
                email
        ).orElseThrow(UserClientNotFoundException::new);
    }

    /**
     * Get a user client by email
     *
     * @param id: int
     *
     * @return UserClient
     *
     * @throws UserClientNotFoundException - if UserClient is not found
     */
    public UserClient getUserClientById(int id) {
        return this.repository.findOneById(
                id
        ).orElseThrow(UserClientNotFoundException::new);
    }

    /**
     * Create a user client
     *
     * @param userClientDto: UserClientDTO
     *
     * @return UserClient
     */
    @Transactional
    public UserClient create(UserClientDTO userClientDto) {
        this.checkByEmail(userClientDto.getEmail());
        userClientDto.setPassword(this.passwordEncoder.encode(userClientDto.getPassword()));

        UserClient userClient = new UserClient();
        userClient.setUnchangeableAttributes(userClientDto);

        this.changeValues(userClient, userClientDto);

        return this.save(userClient);
    }

    /**
     * Update a user client
     *
     * @param email: String
     * @param userClientDto: UserClientDTO
     *
     * @return UserClient
     */
    @Transactional
    public UserClient update(String email, UserClientDTO userClientDto) {
        userClientDto.setPassword(
                ! Utils.isEmptyString(userClientDto.getPassword()) ?
                    this.passwordEncoder.encode(userClientDto.getPassword()) :
                    userClientDto.getPassword()
        );
        UserClient userClient = this.getUserClientByEmail(email);
        this.changeValues(userClient, userClientDto);
        return this.save(userClient);
    }

    /**
     * Exists User Client By email if it is exists throw exception
     *
     * @param email: String
     *
     * @throws UserClientAlreadyExistException - if UserClient already exists
     */
    private void checkByEmail(String email) {
        if(this.repository.existsByEmail(email)){
            throw new UserClientAlreadyExistException();
        }
    }

    /**
     * Set changeable values for create and update
     *
     * @param uc: UserClient
     * @param ucDTO: UserClientDTO
     *
     */
    private void changeValues(UserClient uc, UserClientDTO ucDTO) {
        uc.setChangeableAttributes(ucDTO);
    }

    /**
     * Save user client
     *
     * @param uc: UserClient
     *
     * @return UserClient
     */
    private UserClient save(UserClient uc) {
        return this.repository.save(uc);
    }
}

