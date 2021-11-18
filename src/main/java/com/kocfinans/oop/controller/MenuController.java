package com.kocfinans.oop.controller;

import com.kocfinans.oop.models.Menu;
import com.kocfinans.oop.models.UserAdmin;
import com.kocfinans.oop.models.dto.MenuDTO;
import com.kocfinans.oop.service.IMenuService;
import com.kocfinans.oop.service.IUserAdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Qualifier("MenuController")
@RequestMapping("/menu")
public class MenuController {

    private final IMenuService service;
    private final IUserAdminService userService;

    //TODO Email must be setted for find a company, future oauth2 get principal for email by token
    @GetMapping("/{email}")
    public ResponseEntity<List<Menu>> getAllMenu(
            @PathVariable("email") String email
    ) {
        UserAdmin userAdmin = this.userService.getUserAdminByEmailAndEnable(email);
        return ResponseEntity.ok().body(this.service.getAll(userAdmin.getCompany()));
    }

    @GetMapping("/{id}/{email}")
    public ResponseEntity<Menu> getMenu(
            @PathVariable("id") int menuId,
            @PathVariable("email") String email
    ) {
        UserAdmin userAdmin = this.userService.getUserAdminByEmailAndEnable(email);
        return ResponseEntity.ok().body(this.service.getMenuByIdAndCompany(menuId, userAdmin.getCompany()));
    }

    @PostMapping("/{email}")
    public ResponseEntity<Menu> createMenu(
            @PathVariable("email") String email,
            @RequestBody @Valid MenuDTO menuDTO) {
        UserAdmin userAdmin = this.userService.getUserAdminByEmailAndEnable(email);
        return ResponseEntity.ok().body(this.service.create(userAdmin.getCompany(), menuDTO));
    }

    @PutMapping("/{id}/{email}")
    public ResponseEntity<Menu> updateMenu(
            @PathVariable("id") int menuId,
            @PathVariable("email") String email,
            @RequestBody @Valid MenuDTO menuDTO) {
        UserAdmin userAdmin = this.userService.getUserAdminByEmailAndEnable(email);
        return ResponseEntity.ok().body(this.service.update(menuId, userAdmin.getCompany(), menuDTO));
    }

    @DeleteMapping("/{id}/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenu(
            @PathVariable("id") int menuId,
            @PathVariable("email") String email) {
        UserAdmin userAdmin = this.userService.getUserAdminByEmailAndEnable(email);
        this.service.delete(menuId, userAdmin.getCompany());
    }
}
