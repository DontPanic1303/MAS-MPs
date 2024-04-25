package model;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student implements Serializable {

    private String name;
    private String surName;
    private LocalDate birthDate;
    private String email;
    private Map<String, Competition> competitions = new HashMap<>();
    private Set<Comment> comments = new HashSet<>();
    private Set<Lesson> lessons = new HashSet<>();

    public Student(String name, String surName, LocalDate birthDate, String email) {
        this.setName(name);
        this.setName(surName);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        EkstensjaClass.addStudent(this);
    }

    public Map<String, Competition> getCompetitions() {
        return new HashMap<>(competitions);
    }

    public Competition getCompetitionByName(String name) {
        return competitions.get(name);
    }

    public void addCompetition(Competition c) {
        if (competitions.containsValue(c))
            return;
        competitions.put(c.getName(),c);
        c.addParticipant(this);
    }

    public void removeCompetition(Competition c) {
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
        if (!comments.contains(c))
            return;
        this.comments.remove(c);
        c.delete();
    }

    public void addLesson(Lesson l){
        if (lessons.contains(l))
            return;
        this.lessons.add(l);
    }

    public void removeLesson(Lesson l){
        if (!lessons.contains(l))
            return;
        this.lessons.remove(l);
        l.delete();
    }

    public Set<Lesson> getLessons() {
        return Collections.unmodifiableSet(lessons);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            throw new AttributeConstraintViolationException("Name can not by null");
        if (name.isEmpty())
            throw new AttributeConstraintViolationException("Name can not by empty");
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if (surName == null)
            throw new AttributeConstraintViolationException("Surname can not by null");
        if (surName.isEmpty())
            throw new AttributeConstraintViolationException("Surname can not by empty");
        this.surName = surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null)
            throw new AttributeConstraintViolationException("BirthDate can not by null");
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null)
            throw new AttributeConstraintViolationException("email can not by null");
        if (email.isEmpty())
            throw new AttributeConstraintViolationException("email can not by empty");

        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches())
            throw new AttributeConstraintViolationException("email is incorrect");

        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                '}';
    }
}
