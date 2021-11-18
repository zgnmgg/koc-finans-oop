package com.kocfinans.oop.service.impl;

import com.kocfinans.oop.exception.MenuNotFoundException;
import com.kocfinans.oop.models.Company;
import com.kocfinans.oop.models.Menu;
import com.kocfinans.oop.models.dto.MenuDTO;
import com.kocfinans.oop.models.repo.MenuRepository;
import com.kocfinans.oop.service.IMenuService;
import com.kocfinans.oop.service.IUserAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {

    //Repositories
    private final MenuRepository repository;

    public final IUserAdminService adminService;

    public MenuServiceImpl(MenuRepository repository, UserAdminServiceImpl adminService) {
        this.repository = repository;
        this.adminService = adminService;
    }

    /**
     * Get all menu by company
     *
     * @return List<Menu>
     *
     */
    public List<Menu> getAll(Company company) {
        return this.repository.findAllByCompany(company);
    }

    /**
     * Get a menu by id and company
     *
     * @param id: int
     * @param company: Company
     *
     * @return Menu
     *
     */
    public Menu getMenuByIdAndCompany(int id, Company company) {
        return this.repository.findOneByIdAndCompany(
                id,
                company
        ).orElseThrow(MenuNotFoundException::new);
    }

    /**
     * Get a menu by id and company
     *
     * @param id: int
     *
     * @return Menu
     *
     */
    public Menu getMenuById(int id) {
        return this.repository.findOneById(
                id
        ).orElseThrow(MenuNotFoundException::new);
    }

    /**
     * Create a menu
     *
     * @param company: Company
     * @param menuDTO: MenuDTO
     *
     * @return Menu
     */
    @Transactional
    public Menu create(Company company, MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setUnchangeableAttributes(
                company
        );
        menu.setChangeableAttributes(
                menuDTO
        );

        menu = this.save(menu);
        menu.setImageUrl((menuDTO.isImageExists() && menuDTO.getFile() != null) ?
                this.uploadImage(menu.getId(), menuDTO.getFile()) :
                null
        );

        return this.save(menu);
    }


    /**
     * Update a menu
     *
     * @param menuId: int
     * @param company: Company
     * @param menuDTO: MenuDTO
     *
     * @return Menu
     */
    @Transactional
    public Menu update(int menuId, Company company, MenuDTO menuDTO) {

        Menu menu = this.getMenuByIdAndCompany(menuId, company);
        menuDTO.setImageUrl(menuDTO.isImageExists() ?
                (menuDTO.getFile() != null ?
                        this.uploadImage(menu.getId(), menuDTO.getFile()) :
                        menu.getImageUrl()) :
                null
        );
        menu.setChangeableAttributes(
                menuDTO
        );
        return this.save(menu);
    }


    /**
     * Delete or soft delete a menu
     *
     * @param id: int
     * @param company: Company
     */
    @Transactional
    @SuppressWarnings("Duplicates")
    public void delete(int id, Company company) {
        Menu menu = this.getMenuByIdAndCompany(id, company);
        this.deleteImageIfExists(menu.getImageUrl());
        this.repository.deleteByCompanyAndId(company, id);
    }


    /**
     * Upload a menu image
     *
     * @param id: int - menu id
     * @param file: MultipartFile
     *
     * @return String - full path of the uploaded image
     */
    private String uploadImage(int id, MultipartFile file) {

        //TODO upload menu image
        return null;
    }

    /**
     * Delete a menu image
     *
     * @param path: String
     */
    private void deleteImageIfExists(String path) {
        //TODO FileService integration
    }

    /**
     * Save menu
     *
     * @param menu: Menu
     *
     * @return Menu
     */
    private Menu save(Menu menu) {
        return this.repository.save(menu);
    }
}
