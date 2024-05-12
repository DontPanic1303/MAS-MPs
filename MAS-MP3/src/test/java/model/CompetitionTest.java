package model;

import exceptions.AttributeConstraintViolationException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CompetitionTest {

    @Test
    public void createCompetitionWithAllArgumentsSuccess(){
        LocalDate now = LocalDate.now();
        Competition competition = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );

        Assertions.assertEquals("pierwsze zawody w angielskim sądzie",competition.getName());
        Assertions.assertEquals(now,competition.getDate());
    }

    @Test
    public void createCompetitionWithDateNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Competition competition = new Competition(
                            null,
                            "pierwsze zawody w angielskim sądzie"
                    );
                }
        );
    }


    @Test
    public void createCommentWithNameNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate now = LocalDate.now();
                    Competition competition = new Competition(
                            now,
                            null
                    );
                }
        );
    }


    @Test
    public void createCommentWithNameEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate now = LocalDate.now();
                    Competition competition = new Competition(
                            now,
                            ""
                    );
                }
        );
    }


    @Test
    public void setNameSuccess(){
        LocalDate now = LocalDate.now();
        Competition competition = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );
        competition.setName("drugie zawody w angielskim sądzie");
        Assertions.assertEquals("drugie zawody w angielskim sądzie",competition.getName());
    }

    @Test
    public void setNameNull(){
        LocalDate now = LocalDate.now();
        Competition competition = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    competition.setName(null);
                }
        );
    }

    @Test
    public void setNameEmpty(){
        LocalDate now = LocalDate.now();
        Competition competition = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    competition.setName("");
                }
        );
    }

    @Test
    public void setDateSuccess(){
        LocalDate now = LocalDate.now();
        Competition competition = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );
        now = LocalDate.now();
        competition.setDate(now);
        Assertions.assertEquals(now,competition.getDate());
    }

    @Test
    public void setDateNull(){
        LocalDate now = LocalDate.now();
        Competition competition = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    competition.setDate(null);
                }
        );
    }

    @Test
    public void createCompetitionWithNotUniqueName(){
        LocalDate now = LocalDate.now();
        Competition competition = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Competition competition2 = new Competition(
                            now,
                            "pierwsze zawody w angielskim sądzie"
                    );
                }
        );
    }

}