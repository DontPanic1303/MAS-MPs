package association;

import features.EkstensjaClass;
import model.Competition;
import model.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Subject_Competition {
    Competition c1;
    Subject s1;
    Subject s2;

    @BeforeEach
    void setup() {
        EkstensjaClass.cleanCompetition();
        LocalDate now = LocalDate.now();
        c1 = new Competition(
                now,
                "pierwsze zawody w angielskim sądzie"
        );
        s1 = new Subject(
                "english",
                "B2"
        );
        s2 = new Subject(
                "english",
                "B1"
        );

    }

    @Test
    void setDeptTest() {
        c1.setSubject(s1);
        assertEquals(s1, c1.getSubject());
        assertTrue(s1.getCompetitions().contains(c1));
    }

    @Test
    void addEmpTest() {
        //should not allow to add relation with a null for a collection
        assertThrows(IllegalArgumentException.class, () -> s1.addCompetition(null));
        s1.addCompetition(c1);
        assertEquals(s1, c1.getSubject());
        assertTrue(s1.getCompetitions().contains(c1));
    }

    @Test
    void addAndRemoveFromEmp() {
        c1.setSubject(s1);
        assertEquals(s1, c1.getSubject());
        assertTrue(s1.getCompetitions().contains(c1));

        c1.setSubject(null);
        assertEquals(null, c1.getSubject());
        assertFalse(s1.getCompetitions().contains(c1));

    }

    @Test
    void addAndRemoveFromDept() {
        c1.setSubject(s1);
        assertEquals(s1, c1.getSubject());
        assertTrue(s1.getCompetitions().contains(c1));

        s1.removeCompetition(c1);
        assertEquals(null, c1.getSubject());
        assertFalse(s1.getCompetitions().contains(c1));

    }
    @Test
    void testReplaceDepartment() {
        c1.setSubject(s1);
        assertEquals(s1, c1.getSubject());
        assertTrue(s1.getCompetitions().contains(c1));

        c1.setSubject(s2);

        //first relation should be removed
        assertFalse(s1.getCompetitions().contains(c1));

        //secondary relation should be set
        assertEquals(s2, c1.getSubject());
        assertTrue(s2.getCompetitions().contains(c1));
    }
}
