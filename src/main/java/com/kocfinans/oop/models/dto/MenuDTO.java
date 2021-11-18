package com.kocfinans.oop.models.dto;

import com.kocfinans.oop.models.validator.Create;
import com.kocfinans.oop.models.validator.Update;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MenuDTO {

    @NotNull(groups = { Create.class, Update.class })
    @NotEmpty(groups = { Create.class, Update.class })
    private String name;
    @NotNull(groups = { Create.class, Update.class })
    @Min(value = 0, groups = { Create.class, Update.class })
    private Double price;
    private String imageUrl;

    private MultipartFile file;
    private boolean imageExists = false;
}
