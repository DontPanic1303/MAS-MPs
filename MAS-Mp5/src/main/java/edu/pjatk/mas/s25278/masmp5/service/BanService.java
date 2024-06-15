package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.model.Administrator;
import edu.pjatk.mas.s25278.masmp5.model.Ban;
import edu.pjatk.mas.s25278.masmp5.model.Person;
import edu.pjatk.mas.s25278.masmp5.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BanService {

    private final BanRepository banRepository;
    private final PersonRepository personRepository;
    private final AdministratorRepository administratorRepository;

    public void banUser(Administrator administrator, Person person, LocalDate localDate, int days){

        Optional<Administrator> administrator1 = administratorRepository.findById(person.getId());

        if (administrator1.isPresent())
            throw new IllegalArgumentException("You can not ban administrator");

        Ban ban = Ban.builder()
                .startTime(localDate)
                .days(days)
                .imposedOn(person)
                .imposedBy(administrator)
                .build();

        banRepository.save(ban);

        person.getBans().add(ban);
        administrator.getGivenBans().add(ban);

        administratorRepository.save(administrator);
        personRepository.save(person);

    }
}
