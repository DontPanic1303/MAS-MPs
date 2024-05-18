package features;

import enums.LessonStatus;
import model.*;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EkstensjaClassTest {

    @Test
    public void save() throws IOException {
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        Tutor tutor = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                50.0
        );
        Tutor.setMinimalHourlySalary(50.0);
        LocalDateTime date = LocalDateTime.of(2024,5,13, 12 ,12);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                tutor,
                student
        );
        Subject subject = new Subject(
                "english",
                "B2"
        );
        Subject subject2 = new Subject(
                "english",
                "B1"
        );
        LocalDate now = LocalDate.now();
        Competition competition = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );
        now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "i",
                now,
                student
        );
        EkstensjaClass.save("All");
    }

    @Test
    public void load() throws IOException, ClassNotFoundException {
        EkstensjaClass.load("All");
        System.out.println(EkstensjaClass.getStudentList());
        System.out.println(EkstensjaClass.getTutorList());
        System.out.println(EkstensjaClass.getLessonList());
        System.out.println(EkstensjaClass.getCommentList());
        System.out.println(EkstensjaClass.getCompetitionList());
        System.out.println(EkstensjaClass.getSubjectList());
        System.out.println(Tutor.getMinimalHourlySalary());
    }

}
