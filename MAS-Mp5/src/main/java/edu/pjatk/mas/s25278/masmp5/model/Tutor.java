package edu.pjatk.mas.s25278.masmp5.model;

import edu.pjatk.mas.s25278.masmp5.validation.MinHourlySalary;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Tutor extends Person {


    @Pattern(regexp = "^(\\d{3}[- .]?){2}\\d{3}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotNull
    private LocalDate jojningDate;

    @NotNull
    @MinHourlySalary
    private Double hourly_salary;

    @Getter
    private static Double minimal_hourly_salary = 20.0;

    public static void setMinimal_hourly_salary(Double minimal_hourly_salary) {
        if (minimal_hourly_salary < 0)
            throw new IllegalArgumentException("Minimal hourly salary can not bu on minus");
        Tutor.minimal_hourly_salary = minimal_hourly_salary;
    }

}
