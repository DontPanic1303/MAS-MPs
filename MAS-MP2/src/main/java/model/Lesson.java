package model;

import enums.LessonStatus;

import java.io.Serializable;
import java.time.LocalDate;

public class Lesson implements Serializable {

    private LocalDate date;
    private LessonStatus lessonStatus;
    private String address;

    public Lesson(LocalDate date, LessonStatus lessonStatus, String address) {
        this.date = date;
        this.lessonStatus = lessonStatus;
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LessonStatus getLessonStatus() {
        return lessonStatus;
    }

    public void setLessonStatus(LessonStatus lessonStatus) {
        this.lessonStatus = lessonStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "date=" + date +
                ", lessonStatus=" + lessonStatus +
                ", adress='" + address + '\'' +
                '}';
    }
}


