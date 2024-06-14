package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.DTO.TutorDTO;
import edu.pjatk.mas.s25278.masmp5.model.Subject;
import edu.pjatk.mas.s25278.masmp5.model.Tutor;
import edu.pjatk.mas.s25278.masmp5.repository.SubjectRepository;
import edu.pjatk.mas.s25278.masmp5.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    public List<TutorDTO> getAllTutorWhoTeachSubjectById(long id){
        List<Tutor> tutors = tutorRepository.findAll();
        tutors = tutors.stream()
                .filter(tutor -> tutor.getSubject().stream()
                                      .anyMatch(subject ->  subject.getId().equals(id)))
                .collect(Collectors.toList());
        return tutors.stream()
                .map(tutor -> new TutorDTO(tutor.getId(),tutor.getName(),tutor.getSurName(), tutor.getHourly_salary()))
                .collect(Collectors.toList());
    }

}
