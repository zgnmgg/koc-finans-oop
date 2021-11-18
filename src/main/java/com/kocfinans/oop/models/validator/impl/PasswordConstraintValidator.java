package com.kocfinans.oop.models.validator.impl;


import com.kocfinans.oop.models.validator.ValidPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(final ValidPassword arg0) {

    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        // @formatter:off
        final PasswordValidator validator = new PasswordValidator(Arrays.asList(
    		  // length between 6 and 30 characters
    		  new LengthRule(6, 30),
    		  // at least one upper-case character
    		  new CharacterRule(EnglishCharacterData.UpperCase, 1),
    		  // at least one lower-case character
    		  new CharacterRule(EnglishCharacterData.LowerCase, 1),
    		  // at least one digit character
    		  new CharacterRule(EnglishCharacterData.Digit, 1),
    		  // no whitespace
    		  new WhitespaceRule()));
        final RuleResult result = validator.validate(new PasswordData(password != null ? password : ""));
        if (result.isValid()) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(String.join(",", validator.getMessages(result))).addConstraintViolation();
        return false;
    }

}
