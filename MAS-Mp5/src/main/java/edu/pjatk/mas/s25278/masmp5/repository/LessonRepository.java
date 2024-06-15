package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Configuration;
import edu.pjatk.mas.s25278.masmp5.model.Lesson;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    public List<Lesson> findAllByTutorIdAndStartDate(Long tutor_id, @NotNull LocalDate startTime);
    public Optional<Lesson> findAllByStudentIdAndStartDateAndStartTime(Long student_id, @NotNull LocalDate startDate, @NotNull @Min(0) @Max(23) int startTime);

    @Query("from Lesson as l join fetch l.payment where l.tutor.id = :tutor_id")
    public List<Lesson> findAllByTutorId(Long tutor_id);

    public Optional<Lesson> findByPaymentId(Long payment_id);

    @Query("from Lesson as l where l.tutor.id = :personId OR l.student.id = :personId")
    public List<Lesson> findAllByPersonId(Long personId);

}
