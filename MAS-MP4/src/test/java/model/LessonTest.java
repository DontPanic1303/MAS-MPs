package model;

import enums.LessonStatus;
import exceptions.AttributeConstraintViolationException;
import exceptions.ExistingRelatedLessonException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LessonTest {

    Student student;
    Tutor tutor;

    Student student2;

    Tutor tutor2;

    @BeforeEach
    public void createComentator() {
        LocalDate birthdate = LocalDate.of(2000, 1, 1);
        student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        tutor = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990, 11, 11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                50.0
        );
        student2 = new Student(
                "Anna",
                "Nowak",
                birthdate,
                "anna.nowak@wp.pl"
        );
        tutor2 = new Tutor(
                "Adam",
                "Zieliński",
                LocalDate.of(1985, 5, 20),
                "adam.zielinski@gmail.com",
                "987654321",
                LocalDate.now(),
                60.0
        );
    }

    @Test
    public void createLessonWithAllArgumentsSuccess(){
        LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                tutor,
                student
        );

        Assertions.assertEquals(LessonStatus.BOOKED,lesson.getLessonStatus());
        Assertions.assertEquals("kolorowa 132",lesson.getAddress());
        Assertions.assertEquals(date,lesson.getStartTime());
    }

    @Test
    public void createLessonWithDateNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate date = LocalDate.of(2024,5,13);
                    Lesson lesson = new Lesson(
                            null,
                            LessonStatus.BOOKED,
                            "kolorowa 132",
                            tutor,
                            student
                    );
                }
        );
    }

    @Test
    public void createLessonWithAddressNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
                    Lesson lesson = new Lesson(
                            date,
                            LessonStatus.BOOKED,
                            null,
                            tutor,
                            student
                    );
                }
        );
    }

    @Test
    public void createLessonWithLessonStatusNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
                    Lesson lesson = new Lesson(
                            date,
                            null,
                            "kolorowa 132",
                            tutor,
                            student
                    );
                }
        );
    }

    @Test
    public void createLessonWithAddressEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
                    Lesson lesson = new Lesson(
                            date,
                            LessonStatus.BOOKED,
                            "",
                            tutor,
                            student
                    );
                }
        );
    }

    @Test
    public void setAddressSuccess(){
        LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                tutor,
                student
        );
        lesson.setAddress("nowt świat 4");
        Assertions.assertEquals("nowt świat 4",lesson.getAddress());
    }

    @Test
    public void setAddressNull(){
        LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                tutor,
                student
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    lesson.setAddress(null);
                }
        );
    }

    @Test
    public void setAddressEmpty(){
        LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                tutor,
                student
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    lesson.setAddress("");
                }
        );
    }

    @Test
    public void setLessonStatusSuccess(){
        LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                tutor,
                student
        );
        lesson.setLessonStatus(LessonStatus.COMPLETED);
        Assertions.assertEquals(LessonStatus.COMPLETED,lesson.getLessonStatus());
    }

    @Test
    public void setLessonStatusNull(){
        LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                tutor,
                student
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    lesson.setLessonStatus(null);
                }
        );
    }

    @Test
    public void setDateSuccess(){
        LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                tutor,
                student
        );
        date = LocalDateTime.of(2024,5,14,4,46);
        lesson.setStartTime(date);
        Assertions.assertEquals(date,lesson.getStartTime());
    }

    @Test
    public void setDateNull(){
        LocalDateTime date = LocalDateTime.of(2024,5,13,13,56);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132",
                tutor,
                student
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    lesson.setStartTime(null);
                }
        );
    }

    @Test
    public void testLessonsWith2HourDifference() {
        LocalDateTime date1 = LocalDateTime.of(2024, 5, 13, 13, 0);
        LocalDateTime date2 = date1.plusHours(2);

        Lesson l1 = new Lesson(date1, LessonStatus.PLANED, "address1", tutor, student);
        Lesson l2 = new Lesson(date2, LessonStatus.PLANED, "address2", tutor, student);

        // Test logic here, e.g., check if the lessons are correctly created
        assertNotEquals(l1.getStartTime(), l2.getStartTime());
    }

    @Test
    public void testLessonsWithSameStartTimeSameParticipants() {
        LocalDateTime date = LocalDateTime.of(2024, 5, 13, 13, 0);

        Lesson l1 = new Lesson(date, LessonStatus.PLANED, "address1", tutor, student);

        assertThrows(ExistingRelatedLessonException.class,
                () -> {
                    Lesson l2 = new Lesson(date, LessonStatus.PLANED, "address2", tutor, student);
                }
        );
    }

    @Test
    public void testLessonsWithSameStartTimeDifferentParticipants() {
        LocalDateTime date = LocalDateTime.of(2024, 5, 13, 13, 0);

        Lesson l1 = new Lesson(date, LessonStatus.PLANED, "address1", tutor, student);
        Lesson l2 = new Lesson(date, LessonStatus.PLANED, "address2", tutor2, student2);

        Assertions.assertEquals(l1.getStartTime(), l2.getStartTime());
        Assertions.assertNotEquals(l1.getTutor(), l2.getTutor());
        Assertions.assertNotEquals(l1.getStudent(), l2.getStudent());
    }

    @Test
    public void testLessonStartsBeforeAnotherWithin1HourSameTutor() {
        LocalDateTime date1 = LocalDateTime.of(2024, 5, 13, 13, 0);
        LocalDateTime date2 = date1.plusMinutes(50);

        Lesson l1 = new Lesson(date1, LessonStatus.PLANED, "address1", tutor, student);

        assertThrows(ExistingRelatedLessonException.class,
                () -> {
                    Lesson l2 = new Lesson(date2, LessonStatus.PLANED, "address2", tutor, student2);
                }
        );

    }

    @Test
    public void testLessonStartsAfterAnotherWithin1HourSameStudent() {
        LocalDateTime date1 = LocalDateTime.of(2024, 5, 13, 14, 0);
        LocalDateTime date2 = date1.minusMinutes(50);

        Lesson l1 = new Lesson(date1, LessonStatus.PLANED, "address1", tutor, student);
        assertThrows(ExistingRelatedLessonException.class,
                () -> {
                    Lesson l2 = new Lesson(date2, LessonStatus.PLANED, "address2", tutor2, student);
                }
        );
    }

    @Test
    public void testLessonsWithSameStartTimeSameParticipantsOneCanceled() {
        LocalDateTime date = LocalDateTime.of(2024, 5, 13, 13, 0);

        Lesson l1 = new Lesson(date, LessonStatus.PLANED, "address1", tutor, student);
        l1.setLessonStatus(LessonStatus.CANCELED);
        Lesson l2 = new Lesson(date, LessonStatus.PLANED, "address2", tutor, student);

    }

}