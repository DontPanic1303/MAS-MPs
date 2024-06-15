package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Competition;
import edu.pjatk.mas.s25278.masmp5.model.Configuration;
import edu.pjatk.mas.s25278.masmp5.model.Offline;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OfflineRepository extends CrudRepository<Offline, Long> {

    public Optional<Offline> findByCompetition(Competition competition);

}
