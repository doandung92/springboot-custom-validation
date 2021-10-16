package com.example.customannotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SignUpValidator
        implements ConstraintValidator<SignUp, SignUpRequest> {

    @Override
    public void initialize(SignUp constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(SignUpRequest request, ConstraintValidatorContext ctx) {
        if (request.getAge() == null || request.getExp() == null) return true;
        return request.getAge() > request.getExp();
    }
}
