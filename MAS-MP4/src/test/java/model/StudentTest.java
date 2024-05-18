package model;

import exceptions.AttributeConstraintViolationException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void createStudentWithAllArgumentsSuccess(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );

        Assertions.assertEquals("Jan",student.getName());
        Assertions.assertEquals("Kowalski",student.getSurName());
        Assertions.assertEquals("jan.kowalski@wp.pl",student.getEmail());
        Assertions.assertEquals(birthdate,student.getBirthDate());
    }

    @Test
    public void createStudentWithNameNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate birthdate = LocalDate.of(2000,1,1);
                    Student student = new Student(
                            null,
                            "Kowalski",
                            birthdate,
                            "jan.kowalski@wp.pl"
                    );
                }
        );
    }

    @Test
    public void createStudentWithSurnameNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate birthdate = LocalDate.of(2000,1,1);
                    Student student = new Student(
                            "Jan",
                            null,
                            birthdate,
                            "jan.kowalski@wp.pl"
                    );
                }
        );
    }

    @Test
    public void createStudentWithBirthdateNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate birthdate = LocalDate.of(2000,1,1);
                    Student student = new Student(
                            "Jan",
                            "Kowalski",
                            null,
                            "jan.kowalski@wp.pl"
                    );
                }
        );
    }

    @Test
    public void createStudentWithEmailNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate birthdate = LocalDate.of(2000,1,1);
                    Student student = new Student(
                            "Jan",
                            "Kowalski",
                            birthdate,
                            null
                    );
                }
        );
    }

    @Test
    public void createStudentWithNameEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate birthdate = LocalDate.of(2000,1,1);
                    Student student = new Student(
                            "",
                            "Kowalski",
                            birthdate,
                            "jan.kowalski@wp.pl"
                    );
                }
        );
    }

    @Test
    public void createStudentWithSurnameEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate birthdate = LocalDate.of(2000,1,1);
                    Student student = new Student(
                            "Jan",
                            "",
                            birthdate,
                            "jan.kowalski@wp.pl"
                    );
                }
        );
    }

    @Test
    public void createStudentWithEmailEmpty(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    LocalDate birthdate = LocalDate.of(2000,1,1);
                    Student student = new Student(
                            "Jan",
                            "Kowalski",
                            birthdate,
                            ""
                    );
                }
        );
    }

    @Test
    public void setNameSuccess(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        student.setName("Paweł");
        Assertions.assertEquals("Paweł",student.getName());
    }

    @Test
    public void setNameNull(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    student.setName(null);
                }
        );
    }

    @Test
    public void setNameEmpty(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    student.setName("");
                }
        );
    }

    @Test
    public void setSurnameSuccess(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        student.setSurName("Kowal");
        Assertions.assertEquals("Kowal",student.getSurName());
    }

    @Test
    public void setSurnameNull(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    student.setSurName(null);
                }
        );
    }

    @Test
    public void setSurnameEmpty(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    student.setSurName("");
                }
        );
    }

    @Test
    public void setBirthdateSuccess(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        birthdate = LocalDate.of(2000,1,2);
        student.setBirthDate(birthdate);
        Assertions.assertEquals(birthdate,student.getBirthDate());
    }

    @Test
    public void setBirthdateNull(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    student.setBirthDate(null);
                }
        );
    }

    @Test
    public void setEmailSuccess(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        student.setEmail("jan.kowalski2@wp.pl");
        Assertions.assertEquals("jan.kowalski2@wp.pl",student.getEmail());
    }

    @Test
    public void setEmailNull(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    student.setEmail(null);
                }
        );
    }

    @Test
    public void setEmailEmpty(){
        LocalDate birthdate = LocalDate.of(2000,1,1);
        Student student = new Student(
                "Jan",
                "Kowalski",
                birthdate,
                "jan.kowalski@wp.pl"
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    student.setEmail("");
                }
        );
    }

}