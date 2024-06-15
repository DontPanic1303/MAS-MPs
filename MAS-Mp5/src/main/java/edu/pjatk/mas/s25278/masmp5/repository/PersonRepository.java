package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Person;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    public Optional<Person> findByEmailAndPassword(@NotBlank(message = "Name is mandatory") @Email String email, @NotBlank(message = "password is mandatory") @Size(min = 5, max = 255) String password);

}
