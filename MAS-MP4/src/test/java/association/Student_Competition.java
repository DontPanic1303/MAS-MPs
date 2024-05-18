package association;

import features.EkstensjaClass;
import model.Competition;
import model.Student;
import model.Subject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Student_Competition {

    Competition c1;
    Student s1;

    @BeforeEach
    void setup() {
        EkstensjaClass.cleanCompetition();
        LocalDate now = LocalDate.now();
        c1 = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );
        LocalDate birthdate = LocalDate.of(2000,1,1);
        s1 = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
    }

    @Test
    void createTest() {
        s1.addCompetition(c1);
        assertTrue( s1.getCompetitions().get(c1.getName()) == c1 );
        assertTrue( c1.getParticipants().contains(s1));

        //check if getDeptByName works properly
        assertEquals(c1, s1.getCompetitionByName(c1.getName()));

    }


    @Test
    void createTest2() {
        c1.addParticipant(s1);
        assertTrue( s1.getCompetitions().get(c1.getName()) == c1 );
        assertTrue( c1.getParticipants().contains(s1));

        //check if getDeptByName works properly
        assertEquals(c1, s1.getCompetitionByName(c1.getName()));

    }

    @Test
    void removeTest() {
        s1.addCompetition(c1);
        assertTrue( s1.getCompetitions().get(c1.getName()) == c1 );
        assertTrue( c1.getParticipants().contains(s1));

        s1.removeCompetition(c1);
        assertFalse(c1.getParticipants().contains(s1));
        assertFalse(s1.getCompetitions().containsKey(c1.getName()));
    }

    @Test
    void removeTest2() {
        s1.addCompetition(c1);
        assertTrue( s1.getCompetitions().get(c1.getName()) == c1 );
        assertTrue( c1.getParticipants().contains(s1));

        c1.removeParticipant(s1);
        assertFalse(c1.getParticipants().contains(s1));
        assertFalse(s1.getCompetitions().containsKey(c1.getName()));
    }



}
