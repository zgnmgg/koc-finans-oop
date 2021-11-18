package com.kocfinans.oop.models.validator.impl;

import com.kocfinans.oop.models.validator.EnumValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

    private List<String> valueList;

    @SuppressWarnings("rawtypes")
    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        valueList = new ArrayList<>();
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();

        Enum[] enumValArr = enumClass.getEnumConstants();

        for (Enum enumVal : enumValArr) {
            valueList.add(enumVal.toString().toUpperCase());
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !valueList.contains(value.toUpperCase())) {
            return false;
        }
        return true;
    }

}
