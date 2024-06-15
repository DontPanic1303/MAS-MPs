package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.model.Complain;
import edu.pjatk.mas.s25278.masmp5.model.Person;
import edu.pjatk.mas.s25278.masmp5.repository.ComplainRepository;
import edu.pjatk.mas.s25278.masmp5.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final ComplainRepository complainRepository;
    private final PersonRepository personRepository;

    public void writeComplain(Person author, Person accused, String content, String title) {

        Complain complain = Complain.builder()
                .date(LocalDate.now())
                .content(content)
                .title(title)
                .accused(accused)
                .author(author)
                .build();

        complainRepository.save(complain);

        author.getComplainsAuthor().add(complain);
        accused.getComplainsAccused().add(complain);
        personRepository.saveAll(Set.of(accused,author));

    }

    public boolean logIn(String email, String password) {

        Optional<Person> person = personRepository.findByEmailAndPassword(email,password);

        return person.isPresent();

    }

    public void register(Person person) {

        personRepository.save(person);

    }



}
