package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Ban;
import edu.pjatk.mas.s25278.masmp5.model.Configuration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BanRepository extends CrudRepository<Ban, Long> {

    public List<Ban> findAllByImposedOnId(Long imposedOn_id);

}
