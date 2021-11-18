package com.kocfinans.oop.controller;

import com.kocfinans.oop.models.UserClient;
import com.kocfinans.oop.models.dto.UserClientDTO;
import com.kocfinans.oop.service.IUserClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Qualifier("UserController")
@RequestMapping("/client")
public class UserClientController {
    private final IUserClientService service;

    @GetMapping("/{email}")
    public ResponseEntity<UserClient> getUserClient(
            @PathVariable("email") String email
    ) {
        //TODO Oauth2 integration after that user principal use
        return ResponseEntity.ok().body(this.service.getUserClientByEmail(email));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserClient> createUserClientProfile(
            @RequestBody @Valid UserClientDTO userClientDto) {
        return ResponseEntity.ok().body(this.service.create(userClientDto));
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserClient> updateUserClientProfile(
            @PathVariable("email") String email,
            @RequestBody @Valid UserClientDTO ucDTO) {
        return ResponseEntity.ok().body(this.service.update(email, ucDTO));
    }
}
