package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.enums.LessonStatus;
import edu.pjatk.mas.s25278.masmp5.enums.PaymentStatus;
import edu.pjatk.mas.s25278.masmp5.model.Competition;
import edu.pjatk.mas.s25278.masmp5.model.Lesson;
import edu.pjatk.mas.s25278.masmp5.model.Payment;
import edu.pjatk.mas.s25278.masmp5.model.Student;
import edu.pjatk.mas.s25278.masmp5.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    private final PaymentRepository paymentRepository;
    private final CompetitionRepository competitionRepository;

    public double payment(Long studentId, Long lessonId) {

        Optional<Payment> payment = paymentRepository.findByLessonId(lessonId);

        if (payment.isEmpty())
            throw new IllegalArgumentException("Id lesson is incorrect");

        Optional<Lesson> lesson = lessonRepository.findById(lessonId);

        if (lesson.isEmpty())
            throw new IllegalArgumentException("Id lesson is incorrect");

        if (!Objects.equals(lesson.get().getStudent().getId(), studentId))
            throw new IllegalArgumentException("Student didnt participate lesson is incorrect");

        if (lesson.get().getLessonStatus() == LessonStatus.CANCELED)
            throw new IllegalArgumentException("Lesson is canceled");

        payment.get().setStatus(PaymentStatus.NOTICED);

        paymentRepository.save(payment.get());

        return payment.get().getAmount();
    }

    public void singUpToCompetition(Student student, Competition competition){

        if (competition.getStudents().contains(student))
            throw new IllegalArgumentException("Student is already sing up to this competition");

        student.getParticipates().put(competition.getName(),competition);
        competition.getStudents().add(student);

        studentRepository.save(student);
        competitionRepository.save(competition);

    }

    public String getStudentEmail(Student student){

        return student.getEmail();

    }

}
