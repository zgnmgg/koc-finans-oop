package com.kocfinans.oop.models.dto;

import com.kocfinans.oop.models.validator.Create;
import com.kocfinans.oop.models.validator.Update;
import com.kocfinans.oop.models.validator.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO {
    @NotNull(groups = { Create.class, Update.class })
    @NotEmpty(groups = { Create.class, Update.class })
    @Email(groups = { Create.class, Update.class })
    private String email;
    @NotNull(groups = { Create.class })
    @NotEmpty(groups = { Create.class })
    @ValidPassword(groups = { Create.class, Update.class })
    private String password;
    @NotNull(groups = { Create.class, Update.class })
    @NotEmpty(groups = { Create.class, Update.class })
    private String fullName;
}
