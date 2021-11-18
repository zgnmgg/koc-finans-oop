package com.kocfinans.oop.models.dto;

import com.kocfinans.oop.models.enumerator.Payment;
import com.kocfinans.oop.models.validator.Create;
import com.kocfinans.oop.models.validator.EnumValidator;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class OrderDTO {
    @NotNull(groups = { Create.class})
    @NotEmpty(groups = { Create.class})
    @EnumValidator(enumClass = Payment.class)
    private String paymentMethod;
}
