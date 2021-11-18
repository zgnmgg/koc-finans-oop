package com.kocfinans.oop.service;

import com.kocfinans.oop.models.UserClient;
import com.kocfinans.oop.models.dto.UserClientDTO;

public interface IUserClientService {
    UserClient getUserClientByEmail(String email);
    UserClient getUserClientById(int id);
    UserClient create(UserClientDTO dto);
    UserClient update(String email, UserClientDTO dto);
}
