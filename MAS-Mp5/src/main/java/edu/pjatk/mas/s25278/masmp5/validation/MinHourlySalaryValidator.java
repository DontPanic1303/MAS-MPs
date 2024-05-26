package edu.pjatk.mas.s25278.masmp5.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MinHourlySalaryValidator implements ConstraintValidator<MinHourlySalary, Double> {

    private double minValue;

    @Override
    public void initialize(MinHourlySalary constraintAnnotation) {
        this.minValue = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value != null && value >= minValue;
    }
}
