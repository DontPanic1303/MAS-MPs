package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.DTO.TutorDTO;
import edu.pjatk.mas.s25278.masmp5.enums.DayOfTheWeek;
import edu.pjatk.mas.s25278.masmp5.enums.LessonStatus;
import edu.pjatk.mas.s25278.masmp5.enums.PaymentStatus;
import edu.pjatk.mas.s25278.masmp5.model.*;
import edu.pjatk.mas.s25278.masmp5.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;
    private final ConfigurationRepository configurationRepository;
    private final LessonRepository lessonRepository;
    private final PaymentRepository paymentRepository;
    private final SubjectRepository subjectRepository;

    public List<TutorDTO> getAllTutorWhoTeachSubjectById(long id){
        List<Tutor> tutors = tutorRepository.findAll();
        tutors = tutors.stream()
                .filter(tutor -> tutor.getSubject().stream()
                                      .anyMatch(subject ->  subject.getId().equals(id)))
                .collect(Collectors.toList());
        return tutors.stream()
                .map(tutor -> new TutorDTO(tutor.getId(),tutor.getName(),tutor.getSurName(), tutor.getHourly_salary()))
                .collect(Collectors.toList());
    }

    public void setNewMinimalHourlySalary(Double newMinimalHourlySalary){
        Configuration configValue = configurationRepository.findByConfigKey("minimalHourlySalary")
                .orElseThrow(() -> new RuntimeException("Minimal hourly salary not configured"));

        configValue.setConfigValue(newMinimalHourlySalary.toString());
        configurationRepository.save(configValue);

        Tutor.setMinimal_hourly_salary(newMinimalHourlySalary);

        List<Tutor> tutors = tutorRepository.findAllByHourly_salaryLessThan(newMinimalHourlySalary);

        for (Tutor tutor: tutors) {
            tutor.setHourly_salary(newMinimalHourlySalary);
        }

        tutorRepository.saveAll(tutors);

    }

    public double payment(Long tutorId) {

        List<Lesson> lessons = lessonRepository.findAllByTutorId(tutorId);

        List<Payment> payments = lessons.stream()
                .map(Lesson::getPayment)
                .filter(payment -> payment.getStatus().equals(PaymentStatus.NOTICED))
                .toList();

        Double sum = 0.0;

        for (Payment p :
                payments) {
            sum+= p.getAmount();
            p.setStatus(PaymentStatus.PAID);
        }

        paymentRepository.saveAll(payments);

        return sum;
    }

    public void setTutorWorkTimeAndDays(String workTime, Set<DayOfTheWeek> dayOfTheWeeks, Tutor tutor) {

        if (!(workTime == null && dayOfTheWeeks == null)) {
            if (workTime != null)
                tutor.setWork_hours(workTime);

            if (dayOfTheWeeks != null)
                tutor.setWork_days(dayOfTheWeeks);

            tutorRepository.save(tutor);
        }
    }

    public void addSubjectToTutor(Subject subject, Tutor tutor){

        if (!tutor.getSubject().contains(subject)){
            tutor.getSubject().add(subject);
            subject.getKnownBy().add(tutor);

            tutorRepository.save(tutor);
            subjectRepository.save(subject);
        }
    }

    public void removeSubjectFromTutor(Subject subject, Tutor tutor){

        if (tutor.getSubject().contains(subject)){
            tutor.getSubject().remove(subject);
            subject.getKnownBy().remove(tutor);

            tutorRepository.save(tutor);
            subjectRepository.save(subject);
        }
    }

}
