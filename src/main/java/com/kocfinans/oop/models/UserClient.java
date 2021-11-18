package com.kocfinans.oop.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kocfinans.oop.helper.Utils;
import com.kocfinans.oop.models.dto.UserClientDTO;
import com.kocfinans.oop.models.enumerator.Gender;
import com.kocfinans.oop.models.enumerator.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_client")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_account_id")
public class UserClient extends User {
    @Column(name = "is_enable", nullable = false)
    private boolean enable;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Istanbul")
    private Timestamp birthDate;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "address")
    private String address;

    public void setUnchangeableAttributes(UserClientDTO userClientDTO) {
        super.setUnchangeableAttributes(userClientDTO);
        this.setEnable(true);
        this.setType(UserType.CLIENT);
    }

    public void setChangeableAttributes(UserClientDTO userClientDTO) {
        super.setChangeableAttributes(userClientDTO);

        if (!Utils.isEmptyString(userClientDTO.getGender()))
            this.setGender(Gender.valueOf(userClientDTO.getGender()));

        if (userClientDTO.getBirthDate() != null)
            this.setBirthDate(userClientDTO.getBirthDate());

        if (!Utils.isEmptyString(userClientDTO.getPhoneNumber()))
            this.setPhoneNumber(userClientDTO.getPhoneNumber());

        if (!Utils.isEmptyString(userClientDTO.getAddress()))
            this.setAddress(userClientDTO.getAddress());

        if (!Utils.isEmptyString(userClientDTO.getCompanyName()))
            this.setCompanyName(userClientDTO.getCompanyName());
    }
}
