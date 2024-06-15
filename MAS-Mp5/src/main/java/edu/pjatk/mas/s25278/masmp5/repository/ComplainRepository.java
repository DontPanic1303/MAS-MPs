package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Complain;
import edu.pjatk.mas.s25278.masmp5.model.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComplainRepository extends CrudRepository<Complain, Long> {

    @Query("from Complain as c join fetch c.author join fetch c.accused")
    public List<Complain> findAll();

}
