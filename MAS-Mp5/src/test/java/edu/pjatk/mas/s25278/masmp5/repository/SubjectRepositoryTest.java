package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class SubjectRepositoryTest {

    @Autowired
    private SubjectRepository subjectRepository;
    @PersistenceContext
    private EntityManager entityManager;

    Subject s1;

    @BeforeEach()
    public void initData() {
        s1 = Subject.builder()
                .name("Fizyka")
                .level("Podstawowy")
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
    public void testFindByNameAndLevel() {
        List<Subject> polski = subjectRepository.findByNameAndLevel("Polski", "Podstawowy");
        assertEquals(1,polski.size());
    }

}