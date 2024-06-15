package edu.pjatk.mas.s25278.masmp5.model;

import edu.pjatk.mas.s25278.masmp5.enums.DayOfTheWeek;
import edu.pjatk.mas.s25278.masmp5.validation.MinHourlySalary;
import edu.pjatk.mas.s25278.masmp5.validation.ValidWorkHours;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

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

    @NotBlank(message = "work_hours is mandatory")
    @ValidWorkHours
    private String work_hours;

    @NotNull
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<DayOfTheWeek> work_days = new HashSet<>();

    @ManyToMany
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Subject> subject = new HashSet<>();

    @OneToMany(mappedBy = "tutor", cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private Set<Lesson> lessons = new HashSet<>();

    @Getter
    private static Double minimal_hourly_salary = 20.0;

    public static void setMinimal_hourly_salary(Double minimal_hourly_salary) {
        if (minimal_hourly_salary < 0)
            throw new IllegalArgumentException("Minimal hourly salary can not bu on minus");
        Tutor.minimal_hourly_salary = minimal_hourly_salary;
    }

    public double getInternshipBonus() {
        LocalDate currentDate = LocalDate.now();

        long yearsOfTutoring = ChronoUnit.YEARS.between(this.jojningDate, currentDate);

        return switch ((int) yearsOfTutoring){
            case 0 -> 0.0;
            case 1 -> 0.05;
            case 2 -> 0.10;
            case 3 -> 0.15;
            default -> 0.20;
        };
    }

}
