package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Competition;
import edu.pjatk.mas.s25278.masmp5.model.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompetitionRepository extends CrudRepository<Competition, Long> {

    @Query("from Competition as c join fetch c.offline join fetch c.online")
    List<Competition> findAll();

}
