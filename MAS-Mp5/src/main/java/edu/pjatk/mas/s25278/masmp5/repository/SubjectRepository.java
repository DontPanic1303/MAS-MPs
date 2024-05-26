package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    public List<Subject> findByName(String name);
    public List<Subject> findByNameAndLevel(String name, String level);
}
