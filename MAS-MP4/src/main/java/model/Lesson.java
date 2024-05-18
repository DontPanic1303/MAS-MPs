package model;

import enums.LessonStatus;
import exceptions.AttributeConstraintViolationException;
import exceptions.ExistingRelatedLessonException;
import features.EkstensjaClass;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class Lesson implements Serializable {

    private LocalDateTime startTime;
    private LessonStatus lessonStatus;
    private String address;
    private Tutor tutor;
    private Student student;

    public Lesson(LocalDateTime startTime, LessonStatus lessonStatus, String address, Tutor tutor, Student student) {
        this.setStartTime(startTime);
        this.setLessonStatus(lessonStatus);
        this.setAddress(address);
        this.setTutor(tutor);
        this.setStudent(student);
        checkIfManyLessonsInOneTime();
        EkstensjaClass.addLesson(this);
        tutor.addLesson(this);
        student.addLesson(this);
    }

    private void checkIfManyLessonsInOneTime() {
        LocalDateTime lessonStartTime = this.getStartTime();
        LocalDateTime lessonEndTime = lessonStartTime.plusMinutes(60);

        Set<Lesson> allRelatedLessons = EkstensjaClass.getLessonList().stream()
                                                        .filter(lesson -> ((lesson.getTutor().equals(this.getTutor()) ||
                                                                            lesson.getStudent().equals(this.student)) &&
                                                                            (lesson.getLessonStatus() == LessonStatus.PLANED ||
                                                                            lesson.getLessonStatus() == LessonStatus.BOOKED)))
                                                        .collect(Collectors.toSet());

        for (Lesson lesson : allRelatedLessons) {

            LocalDateTime existingLessonStartTime = lesson.getStartTime();
            LocalDateTime existingLessonEndTime = existingLessonStartTime.plusMinutes(60);

            boolean overlaps = existingLessonStartTime.isBefore(lessonEndTime.plusHours(1)) &&
                    existingLessonEndTime.isAfter(lessonStartTime.minusHours(1));

            if (overlaps) {
                if (lesson.getTutor().equals(this.getTutor())) {
                    throw new ExistingRelatedLessonException("Tutor has another lesson within the time frame.");
                }

                if (lesson.getStudent().equals(this.getStudent())) {
                    throw new ExistingRelatedLessonException("Tutor has another lesson within the time frame.");
                }
            }
        }
    }

    private void setTutor(Tutor tutor){
        if (tutor==null) {
            this.delete();
            throw new IllegalArgumentException("Tutor can not by null");
        }
        this.tutor=tutor;
    }

    private void setStudent(Student student){
        if (student==null) {
            this.delete();
            throw new IllegalArgumentException("Student can not by null");
        }
        this.student=student;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Student getStudent() {
        return student;
    }

    public void delete(){
        if (tutor != null) {
            tutor.removeLesson(this);
            tutor = null;
        }

        if (student != null) {
            student.removeLesson(this);
            student = null;
        }

        EkstensjaClass.removeLesson(this);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        if (startTime == null)
            throw new AttributeConstraintViolationException("Date can not by null");
        this.startTime = startTime;
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
                "date=" + startTime +
                ", lessonStatus=" + lessonStatus +
                ", adress='" + address + '\'' +
                '}';
    }
}


