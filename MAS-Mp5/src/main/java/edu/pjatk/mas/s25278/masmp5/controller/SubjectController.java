package edu.pjatk.mas.s25278.masmp5.controller;

import edu.pjatk.mas.s25278.masmp5.DTO.SubjectDTO;
import edu.pjatk.mas.s25278.masmp5.model.Subject;
import edu.pjatk.mas.s25278.masmp5.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService){
        this.subjectService=subjectService;
    }

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAllSubject() {
        return ResponseEntity.ok(subjectService.getAllKnownSubject());
    }

}
