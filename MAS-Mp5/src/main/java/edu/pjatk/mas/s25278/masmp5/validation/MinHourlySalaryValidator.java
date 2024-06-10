package edu.pjatk.mas.s25278.masmp5.validation;


import edu.pjatk.mas.s25278.masmp5.service.ConfigurationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MinHourlySalaryValidator implements ConstraintValidator<MinHourlySalary, Double> {

    private final ConfigurationService configurationService;
    private double minValue;

    @Override
    public void initialize(MinHourlySalary constraintAnnotation) {
        if(configurationService != null) {
            this.minValue = configurationService.getMinimalHourlySalary();
        } else {
            throw new IllegalStateException("ConfigurationService not initialized");
        }
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value != null && value >= minValue;
    }
}
