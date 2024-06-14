package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.DTO.LessonCreateDTO;
import edu.pjatk.mas.s25278.masmp5.DTO.LessonDTO;
import edu.pjatk.mas.s25278.masmp5.enums.DayOfTheWeek;
import edu.pjatk.mas.s25278.masmp5.enums.LessonStatus;
import edu.pjatk.mas.s25278.masmp5.enums.PaymentStatus;
import edu.pjatk.mas.s25278.masmp5.model.Lesson;
import edu.pjatk.mas.s25278.masmp5.model.Payment;
import edu.pjatk.mas.s25278.masmp5.model.Student;
import edu.pjatk.mas.s25278.masmp5.model.Tutor;
import edu.pjatk.mas.s25278.masmp5.repository.LessonRepository;
import edu.pjatk.mas.s25278.masmp5.repository.PaymentRepository;
import edu.pjatk.mas.s25278.masmp5.repository.StudentRepository;
import edu.pjatk.mas.s25278.masmp5.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final TutorRepository tutorRepository;
    private final StudentRepository studentRepository;
    private final PaymentRepository paymentRepository;

    public List<LessonDTO> getAllTutorLessonFromDay(Long id, LocalDate startDate) {
        List<Lesson> lessons = lessonRepository.findAllByTutorIdAndStartDate(id,startDate);
        Optional<Tutor> tutor = tutorRepository.findById(id);

        if (tutor.isEmpty())
            throw new IllegalArgumentException("Tutor id is incorrect");

        DayOfWeek dayOfWeek = startDate.getDayOfWeek();

        DayOfTheWeek tutorDayOfWeek;
        switch (dayOfWeek) {
            case MONDAY:
                tutorDayOfWeek = DayOfTheWeek.PONIEDZIAŁEK;
                break;
            case TUESDAY:
                tutorDayOfWeek = DayOfTheWeek.WTOREK;
                break;
            case WEDNESDAY:
                tutorDayOfWeek = DayOfTheWeek.ŚRODA;
                break;
            case THURSDAY:
                tutorDayOfWeek = DayOfTheWeek.CZWARTEK;
                break;
            case FRIDAY:
                tutorDayOfWeek = DayOfTheWeek.PIĄTEK;
                break;
            case SATURDAY:
                tutorDayOfWeek = DayOfTheWeek.SOBOTA;
                break;
            case SUNDAY:
                tutorDayOfWeek = DayOfTheWeek.NIEDZIELA;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dayOfWeek);
        }

        List<LessonDTO> lessonsToReturn = new ArrayList<>();

        if (!tutor.get().getWork_days().contains(tutorDayOfWeek)) {
            return lessonsToReturn;
        }

        String[] hours = tutor.get().getWork_hours().split("-");
        int startHour = Integer.parseInt(hours[0]);
        int endHour = Integer.parseInt(hours[1]);

        Set<Integer> lessonStartTimes = lessons.stream()
                .map(Lesson::getStartTime)
                .collect(Collectors.toSet());

        for (int i = startHour; i < endHour; i++) {
            boolean isReserved = lessonStartTimes.contains(i);
            lessonsToReturn.add(new LessonDTO(i, !isReserved));
        }

        int to4 = lessonsToReturn.size()%4;

        for (int i = 0; i < to4; i++) {
            lessonsToReturn.add(new LessonDTO(i, false));
        }

        return lessonsToReturn;
    }

    public LessonDTO createLesson(LessonCreateDTO lessonCreateDTO){
        Optional<Tutor> tutor = tutorRepository.findById(lessonCreateDTO.getTutor());
        Optional<Student> student = studentRepository.findById(lessonCreateDTO.getStudent());

        if (tutor.isEmpty() || student.isEmpty())
            throw new IllegalArgumentException("Wrong tutor or student id");

        Optional<Lesson> lesson = lessonRepository.findAllByStudentIdAndStartDateAndStartTime(lessonCreateDTO.getStudent(), lessonCreateDTO.getStartDate(), lessonCreateDTO.getStartTime());

        if (lesson.isPresent() && (lesson.get().getLessonStatus() == LessonStatus.BOOKED || lesson.get().getLessonStatus() == LessonStatus.PLANED))
            return new LessonDTO(0,false);
        else {
            Lesson newLesson = Lesson.builder()
                    .student(student.get())
                    .tutor(tutor.get())
                    .lessonStatus(LessonStatus.BOOKED)
                    .startTime(lessonCreateDTO.getStartTime())
                    .startDate(lessonCreateDTO.getStartDate())
                    .build();
            lessonRepository.save(newLesson);
            Payment payment = Payment.builder()
                    .amount(tutor.get().getHourly_salary()+(tutor.get().getHourly_salary()*tutor.get().getInternshipBonus()))
                    .lesson(newLesson)
                    .date(null)
                    .status(PaymentStatus.LACK)
                    .build();
            paymentRepository.save(payment);
            newLesson.setPayment(payment);
            lessonRepository.save(newLesson);
            return new LessonDTO(Math.toIntExact(newLesson.getId()),true);
        }
    }

}
