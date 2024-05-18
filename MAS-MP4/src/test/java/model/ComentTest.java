package model;

import exceptions.AttributeConstraintViolationException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ComentTest {

    Student student;
    @BeforeEach
    public void createComentator(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
    }

    @Test
    public void createCommentWithAllArgumentsSuccess(){
        LocalDate now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "i",
                now,
                student
        );

        Assertions.assertEquals("i like this",coment.getContent());
        Assertions.assertEquals("i",coment.getTitle());
        Assertions.assertEquals(now,coment.getDate());
    }

    @Test
    public void createCommentWithContentNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate now = LocalDate.now();
                    Comment coment = new Comment(
                            null,
                            "i",
                            now,
                            student
                    );
                }
        );
    }

    @Test
    public void createCommentWithTitleNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate now = LocalDate.now();
                    Comment coment = new Comment(
                            "i like this",
                            null,
                            now,
                            student
                    );
                }
        );
    }

    @Test
    public void createCommentWithDateNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Comment coment = new Comment(
                            "i like this",
                            "i",
                            null,
                            student
                    );
                }
        );
    }

    @Test
    public void createCommentWithContentEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate now = LocalDate.now();
                    Comment coment = new Comment(
                            "",
                            "i",
                            now,
                            student
                    );
                }
        );
    }

    @Test
    public void createCommentWithTitleEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate now = LocalDate.now();
                    Comment coment = new Comment(
                            "i like this",
                            "",
                            now,
                            student
                    );
                }
        );
    }

    @Test
    public void setContentSuccess(){
        LocalDate now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "",
                now,
                student
        );
        coment.setContent("Paweł");
        Assertions.assertEquals("Paweł",coment.getContent());
    }

    @Test
    public void setContentNull(){
        LocalDate now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "",
                now,
                student
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    coment.setContent(null);
                }
        );
    }

    @Test
    public void setContentEmpty(){
        LocalDate now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "",
                now,
                student
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    coment.setContent("");
                }
        );
    }

    @Test
    public void setTitleSuccess(){
        LocalDate now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "",
                now,
                student
        );
        coment.setTitle("Paweł");
        Assertions.assertEquals("Paweł",coment.getTitle());
    }

    @Test
    public void setTitleNull(){
        LocalDate now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "",
                now,
                student
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    coment.setTitle(null);
                }
        );
    }

    @Test
    public void setTitleEmpty(){
        LocalDate now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "",
                now,
                student
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    coment.setTitle("");
                }
        );
    }

    @Test
    public void setDateSuccess(){
        LocalDate now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "",
                now,
                student
        );
        now = LocalDate.now();
        coment.setDate(now);
        Assertions.assertEquals(now,coment.getDate());
    }

    @Test
    public void setDateNull(){
        LocalDate now = LocalDate.now();
        Comment coment = new Comment(
                "i like this",
                "",
                now,
                student
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    coment.setDate(null);
                }
        );
    }




}