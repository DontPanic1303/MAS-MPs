package model;

import exceptions.AttributeConstraintViolationException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ComentTest {

    @Test
    public void createCommentWithAllArgumentsSuccess(){
        LocalDate now = LocalDate.now();
        Coment coment = new Coment(
                "i like this",
                "i",
                now
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
                    Coment coment = new Coment(
                            null,
                            "i",
                            now
                    );
                }
        );
    }

    @Test
    public void createCommentWithTitleNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate now = LocalDate.now();
                    Coment coment = new Coment(
                            "i like this",
                            null,
                            now
                    );
                }
        );
    }

    @Test
    public void createCommentWithDateNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Coment coment = new Coment(
                            "i like this",
                            "i",
                            null
                    );
                }
        );
    }

    @Test
    public void createCommentWithContentEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate now = LocalDate.now();
                    Coment coment = new Coment(
                            "",
                            "i",
                            now
                    );
                }
        );
    }

    @Test
    public void createCommentWithTitleEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate now = LocalDate.now();
                    Coment coment = new Coment(
                            "i like this",
                            "",
                            now
                    );
                }
        );
    }

    @Test
    public void setContentSuccess(){
        LocalDate now = LocalDate.now();
        Coment coment = new Coment(
                "i like this",
                "",
                now
        );
        coment.setContent("Paweł");
        Assertions.assertEquals("Paweł",coment.getContent());
    }

    @Test
    public void setContentNull(){
        LocalDate now = LocalDate.now();
        Coment coment = new Coment(
                "i like this",
                "",
                now
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
        Coment coment = new Coment(
                "i like this",
                "",
                now
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
        Coment coment = new Coment(
                "i like this",
                "",
                now
        );
        coment.setTitle("Paweł");
        Assertions.assertEquals("Paweł",coment.getTitle());
    }

    @Test
    public void setTitleNull(){
        LocalDate now = LocalDate.now();
        Coment coment = new Coment(
                "i like this",
                "",
                now
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
        Coment coment = new Coment(
                "i like this",
                "",
                now
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
        Coment coment = new Coment(
                "i like this",
                "",
                now
        );
        now = LocalDate.now();
        coment.setDate(now);
        Assertions.assertEquals(now,coment.getDate());
    }

    @Test
    public void setDateNull(){
        LocalDate now = LocalDate.now();
        Coment coment = new Coment(
                "i like this",
                "",
                now
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    coment.setDate(null);
                }
        );
    }




}