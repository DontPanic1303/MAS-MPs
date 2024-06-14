package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Subject;
import edu.pjatk.mas.s25278.masmp5.model.Tutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    public List<Subject> findByName(String name);

 //   @Query("from Subject as s left join fetch s.knownBy as t left join Person on t.id = Person.id where s.id = :id")
    @Query("from Subject as s left join fetch s.knownBy where s.id = :id")
    public Optional<Subject> findById(@Param("id") Long id);

    @Query("from Subject s order by s.name, s.level")
    public List<Subject> findAll();
}
