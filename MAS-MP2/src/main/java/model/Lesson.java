package model;

import enums.LessonStatus;
import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import java.io.Serializable;
import java.time.LocalDate;

public class Lesson implements Serializable {

    private LocalDate date;
    private LessonStatus lessonStatus;
    private String address;
    private Tutor tutor;
    private Student student;

    public Lesson(LocalDate date, LessonStatus lessonStatus, String address, Tutor tutor, Student student) {
        this.setDate(date);
        this.setLessonStatus(lessonStatus);
        this.setAddress(address);
        this.setTutor(tutor);
        this.setStudent(student);
        EkstensjaClass.addLesson(this);
    }

    private void setTutor(Tutor tutor){
        if (tutor==null) {
            this.delete();
            throw new AttributeConstraintViolationException("Tutor can not by null");
        }
        this.tutor=tutor;
        tutor.addLesson(this);
    }

    private void setStudent(Student student){
        if (student==null) {
            this.delete();
            throw new AttributeConstraintViolationException("Student can not by null");
        }
        this.student=student;
        student.addLesson(this);
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Student getStudent() {
        return student;
    }

    public void delete(){
        tutor.removeLesson(this);
        student.removeLesson(this);
        EkstensjaClass.removeLesson(this);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null)
            throw new AttributeConstraintViolationException("Date can not by null");
        this.date = date;
    }

    public LessonStatus getLessonStatus() {
        return lessonStatus;
    }

    public void setLessonStatus(LessonStatus lessonStatus) {
        if (lessonStatus == null)
            throw new AttributeConstraintViolationException("Lesson Status can not by null");
        this.lessonStatus = lessonStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null)
            throw new AttributeConstraintViolationException("Address can not by null");
        if (address.isEmpty())
            throw new AttributeConstraintViolationException("Address can not by empty");
        this.address = address;
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


