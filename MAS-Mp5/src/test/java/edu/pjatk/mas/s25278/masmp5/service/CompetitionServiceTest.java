package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.enums.SubjectLevel;
import edu.pjatk.mas.s25278.masmp5.model.Competition;
import edu.pjatk.mas.s25278.masmp5.model.Online;
import edu.pjatk.mas.s25278.masmp5.model.Subject;
import edu.pjatk.mas.s25278.masmp5.repository.CompetitionRepository;
import edu.pjatk.mas.s25278.masmp5.repository.OnlineRepository;
import edu.pjatk.mas.s25278.masmp5.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Transactional
class CompetitionServiceTest {

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private OnlineRepository onlineRepository;

    @Test
    public void test() {

        Subject subject = Subject.builder()
                .name("Java")
                .level(SubjectLevel.Podstawowy)
                .build();

        Competition competition = Competition.builder()
                .date(LocalDate.now())
                .name("dsfsd")
                .subject(subject)
                .build();

        subjectRepository.save(subject);
        competitionService.addCompetition(competition);

        competitionService.addOfflineCompetition(competition,"klonowa 1");
        competitionService.removeOfflineCompetition(competition);
        competitionService.addOnlineCompetition(competition,"kot.pl");

        subjectRepository.delete(subject);

        Optional<Competition> competition1 = competitionRepository.findById(competition.getId());

        System.out.println(competition1.isPresent());

        competitionRepository.delete(competition);

        Optional<Online> byCompetition = onlineRepository.findByCompetition(competition);

        System.out.println(byCompetition.isPresent());

    }

}