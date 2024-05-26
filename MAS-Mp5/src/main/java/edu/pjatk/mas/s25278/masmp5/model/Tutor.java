package edu.pjatk.mas.s25278.masmp5.model;

import edu.pjatk.mas.s25278.masmp5.validation.MinHourlySalary;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutor extends Person {


    @NumberFormat
    private String phoneNumber;

    @NotBlank
    private LocalDate jojningDate;

    @NotBlank
    //@MinHourlySalary()
    private Double hourly_salary;

}
