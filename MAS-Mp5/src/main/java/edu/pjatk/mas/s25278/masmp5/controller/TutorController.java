package edu.pjatk.mas.s25278.masmp5.controller;

import edu.pjatk.mas.s25278.masmp5.DTO.TutorDTO;
import edu.pjatk.mas.s25278.masmp5.service.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService){
        this.tutorService = tutorService;
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<List<TutorDTO>> getAllTutorBySubjectId(@PathVariable Long id) {
        return ResponseEntity.ok(tutorService.getAllTutorWhoTeachSubjectById(id));
    }

}
