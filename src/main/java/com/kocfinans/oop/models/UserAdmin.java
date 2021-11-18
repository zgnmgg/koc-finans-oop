package com.kocfinans.oop.models;

import com.kocfinans.oop.models.dto.UserAdminDTO;
import com.kocfinans.oop.models.enumerator.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_admin")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_account_id")
public class UserAdmin extends User {

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @Column(name = "is_enable", nullable = false)
    private boolean enable;

    public void setUnchangeableAttributes(UserAdminDTO userAdminDTO) {
        super.setUnchangeableAttributes(userAdminDTO);
        this.setType(UserType.ADMIN);
        this.setCompany(company);
        this.setEnable(true);
    }

    public void setChangeableAttributes(UserAdminDTO userAdminDTO) {
        super.setChangeableAttributes(userAdminDTO);
    }
}
