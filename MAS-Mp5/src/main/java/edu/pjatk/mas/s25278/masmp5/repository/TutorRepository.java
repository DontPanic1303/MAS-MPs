package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Tutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TutorRepository extends CrudRepository<Tutor, Long> {

    @Query("from Tutor t join fetch Person p on t.id = p.id where t.id = :id")
    public Optional<Tutor> findById(@Param("id") Long id);

}
