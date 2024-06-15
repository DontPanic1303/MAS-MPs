package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.model.Complain;
import edu.pjatk.mas.s25278.masmp5.repository.ComplainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComplainService {

    private final ComplainRepository complainRepository;

    public List<Complain> getAllComplain() {

        return complainRepository.findAll();

    }

    public Complain getComplainById(Long id){

        Optional<Complain> complain = complainRepository.findById(id);

        if (complain.isEmpty())
            throw new IllegalArgumentException("Complain id is incorrect");

        return complain.get();
    }

}
