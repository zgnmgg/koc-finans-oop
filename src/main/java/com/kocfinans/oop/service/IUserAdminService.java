package com.kocfinans.oop.service;

import com.kocfinans.oop.models.UserAdmin;
import com.kocfinans.oop.models.dto.UserAdminDTO;

public interface IUserAdminService {
    UserAdmin create(UserAdminDTO dto, int companyId);
    UserAdmin getUserAdminByEmailAndEnable(String email);
}
