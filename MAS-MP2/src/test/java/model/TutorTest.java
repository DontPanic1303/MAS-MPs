package model;

import exceptions.AttributeConstraintViolationException;
import exceptions.MinimalSetSizeException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TutorTest {

    @Test
    public void setMinimalHourlySalarySuccess(){
        Tutor.setMinimalHourlySalary(20.0);
        Assertions.assertEquals(20.0,Tutor.getMinimalHourlySalary());
    }

    @Test
    public void setMinimalHourlySalaryNull(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> Tutor.setMinimalHourlySalary(null)
        );
    }

    @Test
    public void setMinimalHourlySalaryOnMinus(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> Tutor.setMinimalHourlySalary(-1.0)
        );
    }

    @Test
    public void createTutorWithAllArgumentsSuccess(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );

        Assertions.assertEquals("Jan",t1.getName());
        Assertions.assertEquals("Kowalski",t1.getSurName());
        Assertions.assertEquals(LocalDate.of(1990,11,11),t1.getBirthDate());
        Assertions.assertEquals("jan.kowalski@gmail.com",t1.getEmail());
        Assertions.assertEquals("123456789",t1.getPhoneNumber());
//        Assertions.assertEquals(Set.of("Matematyka","Fizyka"),t1.getSubjects());
        Assertions.assertEquals(50.0,t1.getHourly_salary());

    }

    @Test
    public void createTutorWithoutPhoneNumberSuccess(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );

        Assertions.assertEquals("Jan",t1.getName());
        Assertions.assertEquals("Kowalski",t1.getSurName());
        Assertions.assertEquals(LocalDate.of(1990,11,11),t1.getBirthDate());
        Assertions.assertEquals("jan.kowalski@gmail.com",t1.getEmail());
//        Assertions.assertEquals(Set.of("Matematyka","Fizyka"),t1.getSubjects());
        Assertions.assertEquals(50.0,t1.getHourly_salary());
    }

    @Test
    public void createTutorWithEmptyName(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithNullName(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            null,
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithEmptySurName(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithNullSurName(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            null,
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithNullBirthDate(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            null,
                            "jan.kowalski@gmail.com",
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithEmptyEmail(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "",
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithNullEmail(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            null,
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithWrongEmail(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "email.wp.pl",
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithNullJojningDate(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            null,
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithEmptySubject(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            LocalDate.now(),
                            Set.of(),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithNullSubject(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            LocalDate.now(),
                            null,
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithNullHurlySalary(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            null
                    );
                }
        );
    }

    @Test
    public void createTutorWithEmptyPhoneNumber(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            "",
                            LocalDate.now(),
                            Set.of("Metematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithNullPhoneNumber(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                null,
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );

        Assertions.assertEquals(null,t1.getPhoneNumber());
    }

    @Test
    public void createTutorWithWrongPhoneNumber(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            "12a",
                            LocalDate.now(),
                            Set.of("Matematyka","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithWrongSubject(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            "",
                            LocalDate.now(),
                            Set.of("Subject1","Fizyka"),
                            50.0
                    );
                }
        );
    }

    @Test
    public void createTutorWithToLowHourlySalary(){
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    Tutor t1 = new Tutor(
                            "Jan",
                            "Kowalski",
                            LocalDate.of(1990,11,11),
                            "jan.kowalski@gmail.com",
                            "",
                            LocalDate.now(),
                            Set.of("Matematyka","Fizyka"),
                            10.0
                    );
                }
        );
    }

    @Test
    public void setNameSucces(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        t1.setName("Paweł");
        Assertions.assertEquals("Paweł",t1.getName());
    }

    @Test
    public void setNameNull(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setName(null);
                }
        );
    }

    @Test
    public void setNameEmpty(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setName("");
                }
        );
    }

    @Test
    public void setSurnameSucces(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        t1.setSurName("Białowieski");
        Assertions.assertEquals("Białowieski",t1.getSurName());
    }

    @Test
    public void setSurnameNull(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setSurName(null);
                }
        );
    }

    @Test
    public void setSurnameEmpty(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setSurName("");
                }
        );
    }

    @Test
    public void setBirthdateSucces(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        t1.setBirthDate(LocalDate.of(1991,10,10));
        Assertions.assertEquals(LocalDate.of(1991,10,10),t1.getBirthDate());
    }

    @Test
    public void setBirthdateNull(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setBirthDate(null);
                }
        );
    }

    @Test
    public void setEmailSucces(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        t1.setEmail("jan.kowalski2@gmail.com");
        Assertions.assertEquals("jan.kowalski2@gmail.com",t1.getEmail());
    }

    @Test
    public void setEmailNull(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setEmail(null);
                }
        );
    }

    @Test
    public void setEmailEmpty(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setEmail("");
                }
        );
    }

    @Test
    public void setEmailWrong(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setEmail("email.wp.pl");
                }
        );
    }

    @Test
    public void setPhoneNumberSucces(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        t1.setPhoneNumber("987654321");
        Assertions.assertEquals("987654321",t1.getPhoneNumber());
    }

    @Test
    public void setPhoneNumberNull(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        t1.setPhoneNumber(null);
        Assertions.assertEquals(null,t1.getPhoneNumber());
    }

    @Test
    public void setPhoneNumberEmpty(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setPhoneNumber("");
                }
        );
    }

    @Test
    public void setPhoneNumberWrong(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setPhoneNumber("23as2");
                }
        );
    }

//    @Test
//    public void setSubjectSucces(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka","Fizyka"),
//                50.0
//        );
//        var subjects = Set.of("Polski", "Fizyka");
//        t1.setSubjects(subjects);
//        Assertions.assertEquals(subjects,t1.getSubjects());
//    }

//    @Test
//    public void setSubjectNull(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka","Fizyka"),
//                50.0
//        );
//        assertThrows(AttributeConstraintViolationException.class,
//                () -> {
//                    t1.setSubjects(null);
//                }
//        );
//    }

//    @Test
//    public void setSubjectEmpty(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka","Fizyka"),
//                50.0
//        );
//        var subjects = Set.of("");
//        assertThrows(AttributeConstraintViolationException.class,
//                () -> {
//                    t1.setSubjects(subjects);
//                }
//        );
//    }

    @Test
    public void setHourlySalarySucces(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        t1.setHourly_salary(55.0);
        Assertions.assertEquals(55.0,t1.getHourly_salary());
    }

    @Test
    public void setHourlySalaryNull(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    t1.setHourly_salary(null);
                }
        );
    }

    @Test
    public void setHourlySalaryToSmall(){
        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );
        assertThrows(AttributeConstraintViolationException.class,
                () -> {
                    var hs = Tutor.getMinimalHourlySalary();
                    hs -= 10;
                    t1.setHourly_salary(hs);
                }
        );
    }

//    @Test
//    public void addSubjectSuccess(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka","Fizyka"),
//                50.0
//        );
//        t1.addSubject("Polski");
//        Assertions.assertEquals(Set.of("Matematyka","Fizyka","Polski"),t1.getSubjects());
//    }

//    @Test
//    public void addSubjectNull(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka","Fizyka"),
//                50.0
//        );
//        assertThrows(AttributeConstraintViolationException.class,
//                () -> {
//                    t1.addSubject(null);
//                }
//        );
//    }

//    @Test
//    public void addSubjectEmpty(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka","Fizyka"),
//                50.0
//        );
//        assertThrows(AttributeConstraintViolationException.class,
//                () -> {
//                    t1.addSubject("");
//                }
//        );
//    }
//
//    @Test
//    public void removeSubjectSuccess(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka","Fizyka"),
//                50.0
//        );
//        t1.removeSubject("Matematyka");
//        Assertions.assertEquals(Set.of("Fizyka"),t1.getSubjects());
//    }
//
//    @Test
//    public void removeSubjectNull(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka","Fizyka"),
//                50.0
//        );
//        assertThrows(AttributeConstraintViolationException.class,
//                () -> {
//                    t1.removeSubject(null);
//                }
//        );
//    }
//
//    @Test
//    public void removeSubjectEmpty(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka","Fizyka"),
//                50.0
//        );
//        assertThrows(AttributeConstraintViolationException.class,
//                () -> {
//                    t1.removeSubject("");
//                }
//        );
//    }
//
//    @Test
//    public void removeSubjectToLowSubjects(){
//        Tutor t1 = new Tutor(
//                "Jan",
//                "Kowalski",
//                LocalDate.of(1990,11,11),
//                "jan.kowalski@gmail.com",
//                "123456789",
//                LocalDate.now(),
//                Set.of("Matematyka"),
//                50.0
//        );
//        assertThrows(MinimalSetSizeException.class,
//                () -> {
//                    t1.removeSubject("Matematyka");
//                }
//        );
//    }

}