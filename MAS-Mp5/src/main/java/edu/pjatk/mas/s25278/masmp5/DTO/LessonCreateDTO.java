package edu.pjatk.mas.s25278.masmp5.DTO;

import java.time.LocalDate;

public class LessonCreateDTO {

    private LocalDate startDate;

    private int startTime;
    private Long tutor;
    private Long student;

    public LessonCreateDTO(LocalDate startDate, int startTime, Long tutor, Long student) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.tutor = tutor;
        this.student = student;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setTutor(Long tutor) {
        this.tutor = tutor;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getStartTime() {
        return startTime;
    }

    public Long getTutor() {
        return tutor;
    }

    public Long getStudent() {
        return student;
    }
}
