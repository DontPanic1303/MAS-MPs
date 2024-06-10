package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Student;
import edu.pjatk.mas.s25278.masmp5.model.Tutor;
import edu.pjatk.mas.s25278.masmp5.service.ConfigurationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @MockBean
    private ConfigurationService configurationService;
    Student s1;

    Tutor t1, t2;

    @BeforeEach
    public void initData() {
        s1 = Student.builder()
                .name("Jan")
                .surName("Kowalski")
                .birthDate(LocalDate.of(1990, 11, 11))
                .email("jan.kowalski@wp.pl")
                .build();

        t1 = Tutor.builder()
                .name("Janek")
                .surName("Kowalski")
                .birthDate(LocalDate.of(1991, 11, 11))
                .email("janek.kowalski@wp.pl")
                .hourly_salary(30.0)
                .jojningDate(LocalDate.now())
                .build();
        t2 = Tutor.builder()
                .name("Franek")
                .surName("Kowalski")
                .birthDate(LocalDate.of(1989, 11, 11))
                .email("franek.kowalski@wp.pl")
                .hourly_salary(31.0)
                .jojningDate(LocalDate.now())
                .build();
    }

    @Test
    public void testRequiredDependencies(){
        assertNotNull(personRepository);
        assertNotNull(tutorRepository);
        assertNotNull(studentRepository);
    }

    @Test
    public void testSaveAll() {

        when(configurationService.getMinimalHourlySalary()).thenReturn(20.0);

        tutorRepository.saveAll(Arrays.asList(t1,t2));
        studentRepository.save(s1);
        entityManager.flush();
        assertEquals(3, personRepository.count());
    }

    @Test
    public void testConfigurationServiceInjection() {
        assertNotNull(configurationService);
    }


}