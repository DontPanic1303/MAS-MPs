package edu.pjatk.mas.s25278.masmp5;

import edu.pjatk.mas.s25278.masmp5.enums.DayOfTheWeek;
import edu.pjatk.mas.s25278.masmp5.enums.SubjectLevel;
import edu.pjatk.mas.s25278.masmp5.model.*;
import edu.pjatk.mas.s25278.masmp5.repository.*;
import edu.pjatk.mas.s25278.masmp5.service.ConfigurationService;
import edu.pjatk.mas.s25278.masmp5.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final SubjectRepository subjectRepository;
    private final TutorRepository tutorRepository;
    private final TutorService tutorService;
    private final ConfigurationService configurationService;
    private final StudentRepository studentRepository;
    private final AdministratorRepository administratorRepository;
    private final BanRepository banRepository;
    private final ComplainRepository complainRepository;
    private final CompetitionRepository competitionRepository;
    private final OfflineRepository offlineRepository;
    private final OnlineRepository onlineRepository;

    @EventListener
    public void atStart(ContextRefreshedEvent event) {

//        tutorService.setNewMinimalHourlySalary(25.0);
//        System.out.println(tutorService.payment((long)6));

        configurationService.setMinimalHourlySalary();
        System.out.println(Tutor.getMinimal_hourly_salary());

        System.out.println(subjectRepository.count());



        if (subjectRepository.count()<5){
            Subject s1 = Subject.builder()
                    .name("Fizyka")
                    .level(SubjectLevel.Podstawowy)
                    .build();

            Subject s2 = Subject.builder()
                    .name("Fizyka")
                    .level(SubjectLevel.Srednio_Zawansowany)
                    .build();

            Subject s3 = Subject.builder()
                    .name("Polski")
                    .level(SubjectLevel.Podstawowy)
                    .build();

            Subject s4 = Subject.builder()
                    .name("Polski")
                    .level(SubjectLevel.Srednio_Zawansowany)
                    .build();

            Subject s5 = Subject.builder()
                    .name("Polski")
                    .level(SubjectLevel.Zawansowany)
                    .build();

            Tutor t1 = Tutor.builder()
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
            Tutor t2 = Tutor.builder()
                    .name("Franek")
                    .surName("Kowalski")
                    .birthDate(LocalDate.of(1989, 11, 11))
                    .email("franek.kowalski@wp.pl")
                    .password("password")
                    .hourly_salary(31.0)
                    .jojningDate(LocalDate.now())
                    .work_hours("8-16")
                    .work_days(Set.of(DayOfTheWeek.PONIEDZIAŁEK,DayOfTheWeek.WTOREK,DayOfTheWeek.ŚRODA,DayOfTheWeek.CZWARTEK,DayOfTheWeek.PIĄTEK))
                    .build();

            Tutor t3 = Tutor.builder()
                    .name("Marcin")
                    .surName("Milewski")
                    .birthDate(LocalDate.of(1989, 11, 11))
                    .email("marcin.kowalski@wp.pl")
                    .password("password")
                    .hourly_salary(35.0)
                    .jojningDate(LocalDate.now())
                    .work_hours("8-16")
                    .work_days(Set.of(DayOfTheWeek.SOBOTA,DayOfTheWeek.NIEDZIELA))
                    .build();

            Tutor t4 = Tutor.builder()
                    .name("Bartłomiej")
                    .surName("Kowalski")
                    .birthDate(LocalDate.of(1989, 11, 11))
                    .email("Nowy.mail@wp.pl")
                    .password("password")
                    .hourly_salary(24.0)
                    .jojningDate(LocalDate.now())
                    .work_hours("8-16")
                    .work_days(Set.of(DayOfTheWeek.PONIEDZIAŁEK,DayOfTheWeek.WTOREK,DayOfTheWeek.ŚRODA,DayOfTheWeek.CZWARTEK,DayOfTheWeek.PIĄTEK))
                    .build();

            Tutor t5 = Tutor.builder()
                    .name("Ela")
                    .surName("Adamik")
                    .birthDate(LocalDate.of(1989, 11, 11))
                    .email("ela.kowalski@wp.pl")
                    .password("password")
                    .hourly_salary(27.0)
                    .jojningDate(LocalDate.now())
                    .work_hours("8-16")
                    .work_days(Set.of(DayOfTheWeek.PONIEDZIAŁEK,DayOfTheWeek.WTOREK,DayOfTheWeek.ŚRODA,DayOfTheWeek.CZWARTEK,DayOfTheWeek.PIĄTEK))
                    .build();

            Tutor t6 = Tutor.builder()
                    .name("Natalja")
                    .surName("Andryszak")
                    .birthDate(LocalDate.of(1989, 11, 11))
                    .email("Natalja.kowalski@wp.pl")
                    .password("password")
                    .hourly_salary(38.0)
                    .jojningDate(LocalDate.now())
                    .work_hours("16-24")
                    .work_days(Set.of(DayOfTheWeek.PONIEDZIAŁEK,DayOfTheWeek.WTOREK,DayOfTheWeek.CZWARTEK,DayOfTheWeek.PIĄTEK))
                    .build();

            Student st1 = Student.builder()
                    .name("Uczeń")
                    .surName("Uczelni")
                    .birthDate(LocalDate.of(1989, 11, 11))
                    .email("Uczen.kowalski@wp.pl")
                    .password("password")
                    .build();

            Administrator a1 = Administrator.builder()
                    .name("Uczeń")
                    .surName("Uczelni")
                    .birthDate(LocalDate.of(1989, 11, 11))
                    .email("Administrator.kowalski@wp.pl")
                    .password("password")
                    .salary(43444)
                    .build();

            Ban b1 = Ban.builder()
                    .days(14)
                    .startTime(LocalDate.of(2024,7,7))
                    .imposedBy(a1)
                    .imposedOn(t1)
                    .build();

            Complain c1 = Complain.builder()
                    .author(st1)
                    .accused(t1)
                    .date(LocalDate.now())
                    .title("drunk")
                    .content("Drunk on lesson.")
                    .build();

            Competition co1 = Competition.builder()
                    .date(LocalDate.of(2300,4,2))
                    .name("Matematyka dla zawansowanych")
                    .build();

            Competition co2 = Competition.builder()
                    .date(LocalDate.of(2111,4,2))
                    .name("Matematyka dla wolnomyślicieli")
                    .build();

            Competition co3 = Competition.builder()
                    .date(LocalDate.of(2025,4,2))
                    .name("Polski dla zawansowanych")
                    .build();

            Online o1 = Online.builder()
                    .competition(co2)
                    .link("szkolaPodstawowa.pl/zawody/dla/rodziny/1")
                    .build();

            Online o2 = Online.builder()
                    .competition(co3)
                    .link("szkolaPodstawowa.pl/zawody/dla/rodziny/2")
                    .build();

            Offline of1 = Offline.builder()
                    .competition(co3)
                    .address("Warszawa, kolnowa, 44")
                    .build();

            competitionRepository.saveAll(Set.of(co1,co2,co3));
            offlineRepository.save(of1);
            onlineRepository.saveAll(Set.of(o1,o2));

            co2.setOnline(o1);
            co3.setOnline(o2);
            co3.setOffline(of1);

            competitionRepository.saveAll(Set.of(co2,co3));

            studentRepository.save(st1);
            administratorRepository.save(a1);

            subjectRepository.saveAll(
                    Set.of(s1,s2,s3,s4,s5)
            );

            tutorRepository.saveAll(
                    Set.of(t1,t2,t3,t4,t5,t6)
            );

            complainRepository.save(c1);

            t1.getComplainsAccused().add(c1);
            st1.getComplainsAuthor().add(c1);

            tutorRepository.save(t1);
            studentRepository.save(st1);

            co3.getStudents().add(st1);
            st1.getParticipates().put(co3.getName(),co3);

            studentRepository.save(st1);
            competitionRepository.save(co3);

            banRepository.save(b1);

            a1.getGivenBans().add(b1);
            t1.getBans().add(b1);

            administratorRepository.save(a1);
            tutorRepository.save(t1);

            s1.getKnownBy().add(t1);
            s1.getKnownBy().add(t2);
            s1.getKnownBy().add(t3);

            t1.getSubject().add(s1);
            t2.getSubject().add(s1);
            t3.getSubject().add(s1);

            s2.getKnownBy().add(t1);
            s2.getKnownBy().add(t4);

            t1.getSubject().add(s2);
            t4.getSubject().add(s2);

            s3.getKnownBy().add(t1);
            s3.getKnownBy().add(t2);
            s3.getKnownBy().add(t3);

            t1.getSubject().add(s3);
            t2.getSubject().add(s3);
            t3.getSubject().add(s3);

            s5.getKnownBy().add(t1);
            s5.getKnownBy().add(t2);
            s5.getKnownBy().add(t3);
            s5.getKnownBy().add(t4);
            s5.getKnownBy().add(t5);
            s5.getKnownBy().add(t6);

            t1.getSubject().add(s5);
            t2.getSubject().add(s5);
            t3.getSubject().add(s5);
            t4.getSubject().add(s5);
            t5.getSubject().add(s5);
            t6.getSubject().add(s5);

            subjectRepository.saveAll(
                    Set.of(s1,s2,s3,s4,s5)
            );

            tutorRepository.saveAll(
                    Set.of(t1,t2,t3,t4,t5,t6)
            );
        }

    }

}
