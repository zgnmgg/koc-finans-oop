package com.kocfinans.oop.service;

import com.kocfinans.oop.models.Company;
import com.kocfinans.oop.models.Menu;
import com.kocfinans.oop.models.dto.MenuDTO;

import java.util.List;

public interface IMenuService {
    List<Menu> getAll(Company company);
    Menu getMenuById(int menuId);
    Menu getMenuByIdAndCompany(int menuId, Company company);
    Menu create(Company company, MenuDTO menuDTO);
    Menu update(int menuId, Company company, MenuDTO menuDTO);
    void delete(int menuId, Company company);
}
