package edu.pjatk.mas.s25278.masmp5.model;

import edu.pjatk.mas.s25278.masmp5.enums.LessonStatus;
import edu.pjatk.mas.s25278.masmp5.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDate startDate;

    @NotNull
    @Min(0)
    @Max(23)
    private int startTime;

    @NotNull
    private LessonStatus lessonStatus;

    @OneToOne(mappedBy = "lesson")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    @NotNull
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @NotNull
    private Student student;



}
