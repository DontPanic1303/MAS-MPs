package edu.pjatk.mas.s25278.masmp5.controller;

import edu.pjatk.mas.s25278.masmp5.DTO.LessonCreateDTO;
import edu.pjatk.mas.s25278.masmp5.DTO.LessonDTO;
import edu.pjatk.mas.s25278.masmp5.model.Lesson;
import edu.pjatk.mas.s25278.masmp5.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/lesson")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService){
        this.lessonService=lessonService;
    }

    @GetMapping("/tutor/{id}/{startDat}")
    public ResponseEntity<List<LessonDTO>> getAllTutorLessonsFromDay(@PathVariable Long id, @PathVariable String startDat){
        String[] time = startDat.split("-");
        return ResponseEntity.ok(lessonService.getAllTutorLessonFromDay(id, LocalDate.of(Integer.parseInt(time[0]),Integer.parseInt(time[1]),Integer.parseInt(time[2]))));
    }

    @PostMapping("/create")
    public ResponseEntity<LessonDTO> createLesson(@RequestBody LessonCreateDTO lessonCreateDTO){
        return ResponseEntity.ok(lessonService.createLesson(lessonCreateDTO));
    }

}
