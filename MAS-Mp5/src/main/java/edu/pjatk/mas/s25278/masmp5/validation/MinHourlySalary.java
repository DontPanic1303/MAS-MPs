package edu.pjatk.mas.s25278.masmp5.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = MinHourlySalaryValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MinHourlySalary {
    String message() default "Hourly salary must be at least {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    double value();
}