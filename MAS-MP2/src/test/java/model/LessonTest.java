package model;

import enums.LessonStatus;
import exceptions.AttributeConstraintViolationException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LessonTest {
    @Test
    public void createLessonWithAllArgumentsSuccess(){
        LocalDate date = LocalDate.of(2024,5,13);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132"
        );

        Assertions.assertEquals(LessonStatus.BOOKED,lesson.getLessonStatus());
        Assertions.assertEquals("kolorowa 132",lesson.getAddress());
        Assertions.assertEquals(date,lesson.getDate());
    }

    @Test
    public void createLessonWithDateNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate date = LocalDate.of(2024,5,13);
                    Lesson lesson = new Lesson(
                            null,
                            LessonStatus.BOOKED,
                            "kolorowa 132"
                    );
                }
        );
    }

    @Test
    public void createLessonWithAddressNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate date = LocalDate.of(2024,5,13);
                    Lesson lesson = new Lesson(
                            date,
                            LessonStatus.BOOKED,
                            null
                    );
                }
        );
    }

    @Test
    public void createLessonWithLessonStatusNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate date = LocalDate.of(2024,5,13);
                    Lesson lesson = new Lesson(
                            date,
                            null,
                            "kolorowa 132"
                    );
                }
        );
    }

    @Test
    public void createLessonWithAddressEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate date = LocalDate.of(2024,5,13);
                    Lesson lesson = new Lesson(
                            date,
                            LessonStatus.BOOKED,
                            ""
                    );
                }
        );
    }

    @Test
    public void setAddressSuccess(){
        LocalDate date = LocalDate.of(2024,5,13);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132"
        );
        lesson.setAddress("nowt świat 4");
        Assertions.assertEquals("nowt świat 4",lesson.getAddress());
    }

    @Test
    public void setAddressNull(){
        LocalDate date = LocalDate.of(2024,5,13);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    lesson.setAddress(null);
                }
        );
    }

    @Test
    public void setAddressEmpty(){
        LocalDate date = LocalDate.of(2024,5,13);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    lesson.setAddress("");
                }
        );
    }

    @Test
    public void setLessonStatusSuccess(){
        LocalDate date = LocalDate.of(2024,5,13);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132"
        );
        lesson.setLessonStatus(LessonStatus.COMPLETED);
        Assertions.assertEquals(LessonStatus.COMPLETED,lesson.getLessonStatus());
    }

    @Test
    public void setLessonStatusNull(){
        LocalDate date = LocalDate.of(2024,5,13);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    lesson.setLessonStatus(null);
                }
        );
    }

    @Test
    public void setDateSuccess(){
        LocalDate date = LocalDate.of(2024,5,13);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132"
        );
        date = LocalDate.of(2024,5,14);
        lesson.setDate(date);
        Assertions.assertEquals(date,lesson.getDate());
    }

    @Test
    public void setDateNull(){
        LocalDate date = LocalDate.of(2024,5,13);
        Lesson lesson = new Lesson(
                date,
                LessonStatus.BOOKED,
                "kolorowa 132"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    lesson.setDate(null);
                }
        );
    }
}