package model;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Person implements Serializable {


    private Map<String, Competition> competitions = new HashMap<>();
    private Set<Comment> comments = new HashSet<>();
    private Set<Lesson> lessons = new HashSet<>();

    public Student(String name, String surName, LocalDate birthDate, String email) {
        super(name,surName,birthDate,email);
        EkstensjaClass.addStudent(this);
    }

    public Map<String, Competition> getCompetitions() {
        return new HashMap<>(competitions);
    }

    public Competition getCompetitionByName(String name) {
        return competitions.get(name);
    }

    public void addCompetition(Competition c) {
        if (c == null)
            throw new IllegalArgumentException("Competition can not be null");
        if (competitions.containsValue(c))
            return;
        competitions.put(c.getName(),c);
        c.addParticipant(this);
    }

    public void removeCompetition(Competition c) {
        if (c == null)
            throw new IllegalArgumentException("Competition can not be null");
        if (!competitions.containsValue(c))
            return;
        competitions.remove(c.getName());
        c.removeParticipant(this);
    }

    public Set<Comment> getComments() {
        return Collections.unmodifiableSet(comments);
    }

    public void addComments(Comment c) {
        Comment result = EkstensjaClass.getCommentList().stream()
                .filter(comment -> comment.equals(c))
                .findFirst().orElse(null);
        if (result == null)
            throw new IllegalArgumentException("This comment dos not exists");
        if (result.getCommentator() != this)
            throw new IllegalArgumentException("Comment can not have more that one owner");
        this.comments.add(c);
    }

    public void removeComments(Comment c) {
        if (c == null)
            throw new IllegalArgumentException("Comment can not be null");
        if (!comments.contains(c))
            return;
        this.comments.remove(c);
        c.delete();
    }

    public void addLesson(Lesson l){
        if (l == null)
            throw new IllegalArgumentException("Lesson can not be null");
        Lesson result = EkstensjaClass.getLessonList().stream()
                .filter(lesson -> lesson.equals(l))
                .findFirst().orElse(null);
        if (result == null)
            throw new IllegalArgumentException("This lesson dont exists");
        if (result.getStudent() != this)
            throw new IllegalArgumentException("This lesson have different student");
        if (lessons.contains(l))
            return;
        this.lessons.add(l);
    }

    public void removeLesson(Lesson l){
        if (l == null)
            throw new IllegalArgumentException("Lesson can not be null");
        if (!lessons.contains(l))
            return;
        this.lessons.remove(l);
        l.delete();
    }

    public Set<Lesson> getLessons() {
        return Collections.unmodifiableSet(lessons);
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", surName='" + super.getSurName() + '\'' +
                ", birthDate=" + super.getBirthDate() +
                ", email='" + super.getEmail() + '\'' +
                '}';
    }
}
