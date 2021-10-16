package com.example.customannotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EvenNumberConstraintValidator
        implements ConstraintValidator<EvenNumber, Integer> {

    @Override
    public void initialize(EvenNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer field, ConstraintValidatorContext cxt) {
        if (field == null) return true;
        return field % 2 == 0;
    }



}
