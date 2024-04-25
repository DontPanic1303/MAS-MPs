package model;

import exceptions.AttributeConstraintViolationException;
import exceptions.MinimalSetSizeException;
import features.EkstensjaClass;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tutor implements Serializable {



    private String name;
    private String surName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private LocalDate jojningDate;
    private Double hourly_salary;
    private static Double minimalHourlySalary = 20.0;
    private Set<Subject> subjects = new HashSet<>();

    private Set<Lesson> lessons = new HashSet<>();
    private static final String fileName = "tutorList";

    public Tutor(String name, String surName, LocalDate birthDate, String email, String phoneNumber, LocalDate jojningDate, Double hourly_salary) {
        this.setName(name);
        this.setSurName(surName);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setJojningDate(jojningDate);
        this.setHourly_salary(hourly_salary);
        this.setPhoneNumber(phoneNumber);
        EkstensjaClass.addTutor(this);
    }

    public Tutor(String name, String surName, LocalDate birthDate, String email, LocalDate jojningDate, Double hourly_salary) {
        this.setName(name);
        this.setSurName(surName);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setJojningDate(jojningDate);
        this.setHourly_salary(hourly_salary);
        EkstensjaClass.addTutor(this);
    }

    public double getInternshipBonus() {
        LocalDate currentDate = LocalDate.now();

        long yearsOfTutoring = ChronoUnit.YEARS.between(this.jojningDate, currentDate);

        return switch ((int) yearsOfTutoring){
            case 0 -> 0.5;
            case 1 -> 0.55;
            case 2 -> 0.6;
            case 3 -> 0.65;
            default -> 0.7;
        };
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + Objects.requireNonNullElse(this.phoneNumber, "not given") + '\'' +
                ", jojningDate=" + jojningDate +
//                ", subjects=" + subjects +
                ", hourly_salary=" + hourly_salary +
                '}';
    }


    public void addSubject(Subject s){
        if (subjects.contains(s))
            return;
        this.subjects.add(s);
        s.addTutor(this);
    }

    public void removeSubject(Subject s){
        if (!subjects.contains(s))
            return;
        this.subjects.remove(s);
        s.removeTutor(this);
    }

    public Set<Subject> getSubjects() {
        return Collections.unmodifiableSet(subjects);
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null){
            if (phoneNumber.isEmpty())
                throw new AttributeConstraintViolationException("Phone number can not by empty");

            String phoneRegex = "^(\\d{3}[- .]?){2}\\d{3}$";

            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(phoneNumber);

            if (!matcher.matches())
                throw new AttributeConstraintViolationException("Phone number is incorrect");

        }

        this.phoneNumber = phoneNumber;
    }

    public LocalDate getJojningDate() {
        return jojningDate;
    }
    private void setJojningDate(LocalDate localDate) {
        if (localDate == null)
            throw new AttributeConstraintViolationException("Joining date can not by null");
        this.jojningDate = localDate;
    }

    public double getHourly_salary() {
        return hourly_salary;
    }

    public void setHourly_salary(Double hourly_salary) {
        if (hourly_salary == null)
            throw new AttributeConstraintViolationException("Hourly salary can not by null");
        if (hourly_salary < Tutor.getMinimalHourlySalary())
            throw new AttributeConstraintViolationException("Hourly salary can not by smaller that minimal hourly salary("+Tutor.getMinimalHourlySalary()+")");
        this.hourly_salary = hourly_salary;
    }

    public static Double getMinimalHourlySalary() {
        return minimalHourlySalary;
    }

    public static void setMinimalHourlySalary(Double minimalHourlySalary) {
        if (minimalHourlySalary == null)
            throw new AttributeConstraintViolationException("Minimal hourly salary can not by null");
        if (minimalHourlySalary < 0)
            throw new AttributeConstraintViolationException("Minimal hourly salary can not have minus value");
        Tutor.minimalHourlySalary = minimalHourlySalary;
    }


}
