package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.enums.DayOfTheWeek;
import edu.pjatk.mas.s25278.masmp5.model.Student;
import edu.pjatk.mas.s25278.masmp5.model.Tutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class TutorRepositoryTest {

    Tutor t1, t2;

    @Autowired
    private TutorRepository tutorRepository;

    @BeforeEach
    public void initData() {
        Tutor.setMinimal_hourly_salary(20.0);
        t1 = Tutor.builder()
                .name("Janek")
                .surName("Kowalski")
                .birthDate(LocalDate.of(1991, 11, 11))
                .email("janek.kowalski@wp.pl")
                .password("password")
                .hourly_salary(30.0)
                .jojningDate(LocalDate.now())
                .work_hours("8-16")
                .work_days(Set.of(DayOfTheWeek.CZWARTEK,DayOfTheWeek.NIEDZIELA))
                .build();
        t2 = Tutor.builder()
                .name("Franek")
                .surName("Kowalski")
                .birthDate(LocalDate.of(1989, 11, 11))
                .email("franek.kowalski@wp.pl")
                .password("password")
                .hourly_salary(31.0)
                .jojningDate(LocalDate.now())
                .work_hours("8-16")
                .work_days(Set.of(DayOfTheWeek.CZWARTEK,DayOfTheWeek.NIEDZIELA))
                .build();
    }

    @Test
    void testSaveTutor(){
        tutorRepository.saveAll(Set.of(t1,t2));
        Optional<Tutor> byId = tutorRepository.findById(t1.getId());
        System.out.println(byId);
        System.out.println(byId.get().getName());
    }

}