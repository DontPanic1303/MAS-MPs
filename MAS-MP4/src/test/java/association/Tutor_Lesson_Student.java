package association;

import enums.LessonStatus;
import exceptions.AttributeConstraintViolationException;
import model.Lesson;
import model.Student;
import model.Tutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Tutor_Lesson_Student {

    Student s1;
    Student s2;
    Tutor t1;
    Tutor t2;

    @BeforeEach
    void setup() {
        LocalDate birthdate = LocalDate.of(2000,1,1);
        s1 = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        s2 = new Student(
                "Janek",
                "Kowalski",
                birthdate,
                "janek.kowalski@wp.pl"
        );
        t1 = new Tutor(
                "Janek",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "janek.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                50.0
        );
        t2 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "323456789",
                LocalDate.now(),
                50.0
        );
    }

    @Test
    void createSuccessfully() {
        LocalDateTime date = LocalDateTime.of(2024,5,13, 12,12);
        assertThrows(IllegalArgumentException.class,
                () -> { new Lesson(date,
                        LessonStatus.BOOKED,
                        "kolorowa 132",
                        t1,
                        null); });
        assertThrows(IllegalArgumentException.class,
                () -> { new Lesson(date,
                        LessonStatus.BOOKED,
                        "kolorowa 132",
                        null,
                        s1); });


        Lesson l1 = new Lesson(date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                t1,
                s1);

        //all references should be set
        assertEquals(s1, l1.getStudent());
        assertEquals(t1, l1.getTutor());
        assertTrue(s1.getLessons().contains(l1));
        assertTrue(t1.getLessons().contains(l1));

        //attempt to use add this participation to unrelated Project
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    t2.addLesson(l1);
                }
        );

        //attempt to use add this participation to unrelated employee
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    s2.addLesson(l1);
                }
        );

        //for normal association (not bag or history)
        // we should not be able to make duplicate relation
//        assertThrows(IllegalArgumentException.class,
//                () -> { new Lesson(date,
//                        LessonStatus.BOOKED,
//                        "kolorowa 132",
//                        t1,
//                        s1); }
//        );

        s1.removeLesson(l1);
        //now all 4 references should be removed
        assertTrue(l1.getStudent() == null);
        assertTrue(l1.getTutor() == null);
        assertFalse(s1.getLessons().contains(l1));
        assertFalse(t1.getLessons().contains(l1));
    }

}
