package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.DTO.SubjectDTO;
import edu.pjatk.mas.s25278.masmp5.model.Subject;
import edu.pjatk.mas.s25278.masmp5.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {


    private final SubjectRepository subjectRepository;

    public List<SubjectDTO> getAllKnownSubject() {
        List<Subject> subjects =  subjectRepository.findAll();
        subjects = subjects.stream().filter(subject -> !subject.getKnownBy().isEmpty()).collect(Collectors.toList());
        return subjects.stream()
                .map(subject -> new SubjectDTO(subject.getId(), subject.getName(), subject.getLevel().toString()))
                .collect(Collectors.toList());
    }

    public List<Subject> getAllSubject() {

        return subjectRepository.findAll();

    }

    public void addNewSubject(Subject subject) {

        subjectRepository.save(subject);

    }

}
