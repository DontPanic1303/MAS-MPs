package model;

import exceptions.AttributeConstraintViolationException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectTest {
    @Test
    public void createSubjectWithAllArgumentsSuccess(){
        Subject subject = new Subject(
                "english",
                "B2"
        );

        Assertions.assertEquals("english",subject.getName());
        Assertions.assertEquals("B2",subject.getLevel());
    }

    @Test
    public void createSubjectWithNameNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Subject subject = new Subject(
                            null,
                            "B2"
                    );
                }
        );
    }

    @Test
    public void createSubjectWithLevelNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Subject subject = new Subject(
                            "english",
                            null
                    );
                }
        );
    }

    @Test
    public void createSubjectWithNameEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Subject subject = new Subject(
                            "",
                            "B2"
                    );
                }
        );
    }

    @Test
    public void createSubjectWithLevelEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Subject subject = new Subject(
                            "english",
                            ""
                    );
                }
        );
    }

    @Test
    public void setNameSuccess(){
        Subject subject = new Subject(
                "english",
                "B2"
        );
        subject.setName("polish");
        Assertions.assertEquals("polish",subject.getName());
    }

    @Test
    public void setNameNull(){
        Subject subject = new Subject(
                "english",
                "B2"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    subject.setName(null);
                }
        );
    }

    @Test
    public void setNameEmpty(){
        Subject subject = new Subject(
                "english",
                "B2"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    subject.setName("");
                }
        );
    }

    @Test
    public void setLevelSuccess(){
        Subject subject = new Subject(
                "english",
                "B2"
        );
        subject.setLevel("B1");
        Assertions.assertEquals("B1",subject.getLevel());
    }

    @Test
    public void setLevelNull(){
        Subject subject = new Subject(
                "english",
                "B2"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    subject.setLevel(null);
                }
        );
    }

    @Test
    public void setLevelEmpty(){
        Subject subject = new Subject(
                "english",
                "B2"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    subject.setLevel("");
                }
        );
    }

}