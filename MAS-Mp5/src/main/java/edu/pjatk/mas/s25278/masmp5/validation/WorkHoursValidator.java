package edu.pjatk.mas.s25278.masmp5.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public class WorkHoursValidator implements ConstraintValidator<ValidWorkHours, String> {

    @Override
    public void initialize(ValidWorkHours constraintAnnotation) {

    }

    @Override
    public boolean isValid(String workDays, ConstraintValidatorContext context) {
        if (workDays == null || workDays.isEmpty()) {
            return false;
        }

        try {
            String[] hours = workDays.split("-");

            int startHour = Integer.parseInt(hours[0]);
            int endHour = Integer.parseInt(hours[1]);
            return startHour >= 0 && endHour >= 1 && endHour <= 24 && startHour < endHour;

        } catch (Exception e){
            return false;
        }

    }
}