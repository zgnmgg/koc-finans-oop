package com.kocfinans.oop.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kocfinans.oop.helper.Utils;
import com.kocfinans.oop.models.dto.CompanyDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "company")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@JsonIgnoreProperties({"createdAt", "enable"})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "brand_name", nullable = false)
    private String name;
    @Column(name = "logo_url")
    private String logoUrl;
    @Column(name = "created_at", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Istanbul")
    private Timestamp createdAt;
    @Column(name = "is_enable", nullable = false)
    private boolean enable;
    @Column(name = "name")
    private String fullName;
    @Column(name = "website")
    private String website;
    @Column(name = "business_phone")
    private String businessPhone;
    @Column(name = "address")
    private String address;
    @Column(name = "about")
    private String about;

    public void setUnchangeableAttributes() {
        this.setCreatedAt(Utils.getCurrentTimestamp());
        this.setEnable(true);
    }
    public void setChangeableAttributes(CompanyDTO dto) {
        this.setName(dto.getName());
        this.setLogoUrl(dto.getLogoUrl());
        this.setFullName(dto.getFullName());
        this.setWebsite(dto.getWebsite());
        this.setBusinessPhone(dto.getBusinessPhone());
        this.setAddress(dto.getAddress());
        this.setAbout(dto.getAbout());
    }
}
