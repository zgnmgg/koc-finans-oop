package com.kocfinans.oop.models.dto;

import com.kocfinans.oop.models.validator.Create;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CompanyDTO {

    @NotNull(groups = { Create.class })
    @NotEmpty(groups = { Create.class })
    @Size(max = 100)
    private String name;
    @NotNull(groups = { Create.class })
    @NotEmpty(groups = { Create.class })
    @Size(max = 100)
    private String logoUrl;
    @NotNull(groups = { Create.class })
    @NotEmpty(groups = { Create.class })
    @Size(max = 100)
    private String fullName;
    @NotNull(groups = { Create.class })
    @NotEmpty(groups = { Create.class })
    @Size(max = 100)
    private String website;
    @NotNull(groups = { Create.class })
    @NotEmpty(groups = { Create.class })
    @Size(max = 100)
    private String businessPhone;
    @NotNull(groups = { Create.class })
    @NotEmpty(groups = { Create.class })
    @Size(max = 100)
    private String address;
    @NotNull(groups = { Create.class })
    @NotEmpty(groups = { Create.class })
    @Size(max = 100)
    private String about;
}
