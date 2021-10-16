package com.example.customannotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EvenNumberConstraintValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EvenNumber {
    String message() default "must be an even number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

