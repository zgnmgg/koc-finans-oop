package com.kocfinans.oop.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kocfinans.oop.helper.Utils;
import com.kocfinans.oop.models.dto.MenuDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "menu")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@JsonIgnoreProperties({"company", "price"})
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "price")
    private double price;
    @Column(name = "created_at", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Istanbul")
    private Timestamp createdAt;

    public void setUnchangeableAttributes(Company company) {
        this.setCompany(company);
        this.setCreatedAt(Utils.getCurrentTimestamp());
    }

    public void setChangeableAttributes(MenuDTO menuDTO) {
        this.setName(menuDTO.getName());
        this.setImageUrl(menuDTO.getImageUrl());
        this.setPrice(menuDTO.getPrice());
    }
}
