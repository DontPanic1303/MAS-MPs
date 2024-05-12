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

public class Tutor extends Person implements Serializable {

    private String phoneNumber;
    private LocalDate jojningDate;
    private Double hourly_salary;
    private static Double minimalHourlySalary = 20.0;
    private Set<Subject> subjects = new HashSet<>();

    private Set<Lesson> lessons = new HashSet<>();
    private static final String fileName = "tutorList";

    public Tutor(String name, String surName, LocalDate birthDate, String email, String phoneNumber, LocalDate jojningDate, Double hourly_salary) {
        super(name,surName,birthDate,email);
        this.setJojningDate(jojningDate);
        this.setHourly_salary(hourly_salary);
        this.setPhoneNumber(phoneNumber);
        EkstensjaClass.addTutor(this);
    }

    public Tutor(String name, String surName, LocalDate birthDate, String email, LocalDate jojningDate, Double hourly_salary) {
        super(name,surName,birthDate,email);
        this.setJojningDate(jojningDate);
        this.setHourly_salary(hourly_salary);
        EkstensjaClass.addTutor(this);
    }

    public double getInternshipBonus() {
        LocalDate currentDate = LocalDate.now();

        long yearsOfTutoring = ChronoUnit.YEARS.between(this.jojningDate, currentDate);

        return switch ((int) yearsOfTutoring){
            case 0 -> 0.0;
            case 1 -> 0.05;
            case 2 -> 0.10;
            case 3 -> 0.15;
            default -> 0.20;
        };
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name='" + super.getName() + '\'' +
                ", surName='" + super.getSurName() + '\'' +
                ", birthDate=" + super.getBirthDate() +
                ", email='" + super.getEmail() + '\'' +
                ", phoneNumber='" + Objects.requireNonNullElse(this.phoneNumber, "not given") + '\'' +
                ", jojningDate=" + jojningDate +
//                ", subjects=" + subjects +
                ", hourly_salary=" + hourly_salary +
                '}';
    }


    public void addSubject(Subject s){
        if (s == null)
            throw new IllegalArgumentException("Subject can not be null");
        if (subjects.contains(s))
            return;
        this.subjects.add(s);
        s.addTutor(this);
    }

    public void removeSubject(Subject s){
        if (s == null)
            throw new IllegalArgumentException("Subject can not be null");
        if (!subjects.contains(s))
            return;
        this.subjects.remove(s);
        s.removeTutor(this);
    }

    public Set<Subject> getSubjects() {
        return Collections.unmodifiableSet(subjects);
    }

    public void addLesson(Lesson l){
        if (l == null)
            throw new IllegalArgumentException("Lesson can not be null");
        Lesson result = EkstensjaClass.getLessonList().stream()
                .filter(lesson -> lesson.equals(l))
                .findFirst().orElse(null);
        if (result == null)
            throw new IllegalArgumentException("This lesson dont exists");
        if (result.getTutor() != this)
            throw new IllegalArgumentException("This lesson have different tutor");
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


    @Override
    public double payment() {
        return lessons.size() * ((this.hourly_salary + this.hourly_salary * this.getInternshipBonus()));
    }
}
