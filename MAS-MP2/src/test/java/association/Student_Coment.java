package association;

import features.EkstensjaClass;
import model.Comment;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class Student_Coment {

    Student s1;
    Student s2;

    @BeforeEach
    void setup(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        s1 = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        s2 = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
    }

    @Test
    void createTaskTest() {
        //you cannot create a task without a project
        assertThrows(IllegalArgumentException.class, () -> {
            new Comment(
                "i like this",
                "i",
                LocalDate.now(),
                null);
        });
        Comment c1 = new Comment(
                "i like this",
                "i",
                LocalDate.now(),
                s1
        );
        assertEquals(s1, c1.getCommentator());
        assertTrue(s1.getComments().contains(c1));
    }

    @Test
    void removeTaskFromProjectTest() {
        Comment c1 = new Comment(
                "i like this",
                "i",
                LocalDate.now(),
                s1
        );
        assertEquals(s1, c1.getCommentator());
        assertTrue(s1.getComments().contains(c1));
        assertTrue(EkstensjaClass.getCommentList().contains(c1));

        //remove from project
        s1.removeComments(c1);
        assertEquals(null, c1.getCommentator());
        assertFalse(s1.getComments().contains(c1));

        //task should not exists anymore
        assertFalse(EkstensjaClass.getCommentList().contains(c1));
    }

    @Test
    void switchTaskOwner() {
        Comment c1 = new Comment(
                "i like this",
                "i",
                LocalDate.now(),
                s1
        );
        assertEquals(s1, c1.getCommentator());
        assertTrue(s1.getComments().contains(c1));

        //its not possible to change an owner of a composed object
        assertThrows(IllegalArgumentException.class,
                () -> {
                    s2.addComments(c1);
                }
        );
    }

}
