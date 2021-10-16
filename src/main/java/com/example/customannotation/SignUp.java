package com.example.customannotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SignUpValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SignUp {
    String message() default "Age must greater than experience";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

