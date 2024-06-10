package edu.pjatk.mas.s25278.masmp5;

import edu.pjatk.mas.s25278.masmp5.model.Subject;
import edu.pjatk.mas.s25278.masmp5.model.Tutor;
import edu.pjatk.mas.s25278.masmp5.repository.SubjectRepository;
import edu.pjatk.mas.s25278.masmp5.repository.TutorRepository;
import edu.pjatk.mas.s25278.masmp5.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final SubjectRepository subjectRepository;
    private final TutorRepository tutorRepository;
   // private final ConfigurationService configurationService;

    @EventListener
    public void atStart(ContextRefreshedEvent event) {
        System.out.println("context refreshed");
        Tutor t1, t2;
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
        tutorRepository.saveAll(Arrays.asList(t1,t2));

    }

}
