package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.enums.DayOfTheWeek;
import edu.pjatk.mas.s25278.masmp5.enums.SubjectLevel;
import edu.pjatk.mas.s25278.masmp5.model.Subject;
import edu.pjatk.mas.s25278.masmp5.model.Tutor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class SubjectRepositoryTest {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TutorRepository tutorRepository;
    @PersistenceContext
    private EntityManager entityManager;

    Subject s1;

    @BeforeEach()
    public void initData() {
        s1 = Subject.builder()
                .name("Fizyka")
                .level(SubjectLevel.Podstawowy)
                .build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(subjectRepository);
    }

    @Test
    public void testFetchSubject(){
        var all = subjectRepository.findAll();
        for (Subject s : all) {
            System.out.println(s);
        }
    }

    @Test
    public void testSaveSubject() {
        subjectRepository.save(s1);
        entityManager.flush();
        long count = subjectRepository.count();
        assertEquals(5,count);
    }

    @Test
    public void testSaveInvalidSubjectName() {
        assertThrows(ConstraintViolationException.class, ()->{
            s1.setName("a");
            subjectRepository.save(s1);
            entityManager.flush();
        });
    }

    @Test
    public void testFindByName() {
        List<Subject> polski = subjectRepository.findByName("Polski");
        assertEquals(2,polski.size());
    }


    @Test
    public void testGetTutorsWhoTeachSubject(){
        Tutor t1 = Tutor.builder()
                .name("Janek")
                .surName("Kowalski")
                .birthDate(LocalDate.of(1991, 11, 11))
                .email("janek2.kowalski@wp.pl")
                .hourly_salary(30.0)
                .password("password")
                .jojningDate(LocalDate.now())
                .work_hours("8-16")
                .work_days(Set.of(DayOfTheWeek.CZWARTEK,DayOfTheWeek.NIEDZIELA))
                .build();
        Tutor t2 = Tutor.builder()
                .name("Franek")
                .surName("Kowalski")
                .birthDate(LocalDate.of(1989, 11, 11))
                .email("franek2.kowalski@wp.pl")
                .password("password")
                .hourly_salary(31.0)
                .jojningDate(LocalDate.now())
                .work_hours("8-16")
                .work_days(Set.of(DayOfTheWeek.CZWARTEK,DayOfTheWeek.NIEDZIELA))
                .build();

        t1.getSubject().add(s1);
        tutorRepository.save(t1);
        s1.getKnownBy().add(t1);
        subjectRepository.save(s1);

        Optional<Subject> findById = subjectRepository.findById(s1.getId());
        assertTrue(findById.isPresent());
        System.out.println(findById.get().getKnownBy());

        t2.getSubject().add(s1);
        tutorRepository.save(t2);
        s1.getKnownBy().add(t2);
        subjectRepository.save(s1);

        findById = subjectRepository.findById(s1.getId());
        assertTrue(findById.isPresent());
        System.out.println(findById.get().getKnownBy());
        List<Tutor> tutors = new ArrayList<>(findById.get().getKnownBy());
        for (Tutor tutor : tutors) {
            System.out.println(tutor.getName());
        }

    }

}