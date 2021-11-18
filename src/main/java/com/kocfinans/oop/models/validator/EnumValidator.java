package com.kocfinans.oop.models.validator;

import com.kocfinans.oop.models.validator.impl.EnumValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValidator {

    Class<? extends Enum<?>> enumClass();

    String message() default "{EnumValidator.default}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
