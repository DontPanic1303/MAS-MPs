package association;

import model.Subject;
import model.Tutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Subject_Tutor {

    Subject s1;
    Tutor t1;
    Tutor t2;

    @BeforeEach
    void setup() {
        s1 =  new Subject(
                "english",
                "B2"
        );
        t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                50.0
        );
        t2 = new Tutor(
                "Janek",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "janek.kowalski@gmail.com",
                "223456789",
                LocalDate.now(),
                50.0
        );
    }



    @Test
    void setDeptTest() {
        s1.addTutor(t1);
        assertTrue(s1.getTutors().contains(t1));
        assertTrue(t1.getSubjects().contains(s1));
    }

    @Test
    void addEmpTest() {
        //should not allow to add relation with a null for a collection
        assertThrows(IllegalArgumentException.class, () -> t1.addSubject(null));
        t1.addSubject(s1);
        assertTrue(s1.getTutors().contains(t1));
        assertTrue(t1.getSubjects().contains(s1));
    }

    @Test
    void addAndRemoveFromEmp() {
        s1.addTutor(t1);
        assertTrue(s1.getTutors().contains(t1));
        assertTrue(t1.getSubjects().contains(s1));

        s1.removeTutor(t1);
        assertFalse(s1.getTutors().contains(t1));
        assertFalse(t1.getSubjects().contains(s1));

    }

    @Test
    void addAndRemoveFromDept() {
        s1.addTutor(t1);
        assertTrue(s1.getTutors().contains(t1));
        assertTrue(t1.getSubjects().contains(s1));

        t1.removeSubject(s1);
        assertFalse(s1.getTutors().contains(t1));
        assertFalse(t1.getSubjects().contains(s1));

    }
    @Test
    void testReplaceDepartment() {
        s1.addTutor(t1);
        assertTrue(s1.getTutors().contains(t1));
        assertTrue(t1.getSubjects().contains(s1));

        s1.addTutor(t2);

        //first relation should be removed
        assertTrue(s1.getTutors().contains(t1));
        assertTrue(t1.getSubjects().contains(s1));

        //secondary relation should be set
        assertTrue(s1.getTutors().contains(t2));
        assertTrue(t2.getSubjects().contains(s1));
    }

}
