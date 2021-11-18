package com.kocfinans.oop.controller;

import com.kocfinans.oop.models.UserAdmin;
import com.kocfinans.oop.models.dto.UserAdminDTO;
import com.kocfinans.oop.service.IUserAdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Qualifier("UserAdminController")
@RequestMapping("/admin")
public class UserAdminController {

    private final IUserAdminService service;

    @PostMapping("/sign-up/{companyId}")
    public ResponseEntity<UserAdmin> createUserAdmin(
            @PathVariable("companyId") int companyId,
            @RequestBody @Valid UserAdminDTO userAdminDTO) {
        return ResponseEntity.ok().body(this.service.create(userAdminDTO, companyId));
    }
}
