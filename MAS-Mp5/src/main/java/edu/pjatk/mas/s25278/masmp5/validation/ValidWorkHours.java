package edu.pjatk.mas.s25278.masmp5.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = WorkHoursValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidWorkHours {
    String message() default "Invalid work hours format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
