package com.innoventes.test.app.validator;

import com.innoventes.test.app.validator.annotations.EvenNumberOrZero;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StrengthValidator implements ConstraintValidator<EvenNumberOrZero, Integer> {

    @Override
    public boolean isValid(final Integer strength, final ConstraintValidatorContext constraintValidatorContext) {
        if (strength % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
