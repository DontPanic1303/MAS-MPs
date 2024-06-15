package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.model.Competition;
import edu.pjatk.mas.s25278.masmp5.model.Offline;
import edu.pjatk.mas.s25278.masmp5.model.Online;
import edu.pjatk.mas.s25278.masmp5.repository.CompetitionRepository;
import edu.pjatk.mas.s25278.masmp5.repository.OfflineRepository;
import edu.pjatk.mas.s25278.masmp5.repository.OnlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final OfflineRepository offlineRepository;
    private final OnlineRepository onlineRepository;

    public List<Competition> getAllCompetition() {

        return competitionRepository.findAll();

    }

    public void addCompetition(Competition competition) {

        competitionRepository.save(competition);

    }

    public void addOfflineCompetition(Competition competition, String address) {

        Offline offline = Offline.builder()
                .address(address)
                .competition(competition)
                .build();

        competitionRepository.save(competition);
        offlineRepository.save(offline);

        competition.setOffline(offline);
        competitionRepository.save(competition);

    }

    public void addOnlineCompetition(Competition competition, String link) {

        Online online = Online.builder()
                .link(link)
                .competition(competition)
                .build();

        competitionRepository.save(competition);
        onlineRepository.save(online);

        competition.setOnline(online);
        competitionRepository.save(competition);

    }

    public void removeOfflineCompetition(Competition competition) {

        if (competition.getOffline()!=null){
            Optional<Offline> offline = offlineRepository.findByCompetition(competition);

            if (offline.isEmpty())
                throw new IllegalArgumentException("Can not remove Offline");

            competition.setOffline(null);
            competitionRepository.save(competition);
            offlineRepository.delete(offline.get());
        }
    }

    public void removeOnlineCompetition(Competition competition) {

        if (competition.getOnline()!=null){
            Optional<Online> online = onlineRepository.findByCompetition(competition);

            if (online.isEmpty())
                throw new IllegalArgumentException("Can not remove Offline");

            competition.setOnline(null);
            competitionRepository.save(competition);
            onlineRepository.delete(online.get());
        }

    }



}
