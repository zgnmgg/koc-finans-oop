package com.kocfinans.oop.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kocfinans.oop.models.enumerator.Gender;
import com.kocfinans.oop.models.validator.EnumValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.sql.Timestamp;

@Getter
@Setter
public class UserClientDTO extends UserDTO {
    @EnumValidator(enumClass = Gender.class)
    private String gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Istanbul")
    @Past
    private Timestamp birthDate;
    @Pattern(regexp = "^[0-9]*$")
    @Size(max = 20)
    private String phoneNumber;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String companyName;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String address;
}
