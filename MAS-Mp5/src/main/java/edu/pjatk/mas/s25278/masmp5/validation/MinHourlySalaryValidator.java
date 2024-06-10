package edu.pjatk.mas.s25278.masmp5.validation;


import edu.pjatk.mas.s25278.masmp5.model.Tutor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MinHourlySalaryValidator implements ConstraintValidator<MinHourlySalary, Double> {

    private double minValue;

    @Override
    public void initialize(MinHourlySalary constraintAnnotation) {
            this.minValue = Tutor.getMinimal_hourly_salary();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value != null && value >= minValue;
    }
}
