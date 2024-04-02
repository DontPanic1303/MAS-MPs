package model;

import exceptions.AttributeConstraintViolationException;
import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tutor {

    private static Set<Tutor> tutorList = new HashSet<>();

    private static Set<String> subjectList = Set.of(
            "Matematyka",
            "Fizyka",
            "Polski",
            "Biologia"
            );
    private String name;
    private String surName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private LocalDate jojningDate;
    private Set<String> subjects;
    private Double hourly_salary;
    private static Double minimalHourlySalary = 20.0;

    public Tutor(String name, String surName, LocalDate birthDate, String email, String phoneNumber, LocalDate jojningDate, Set<String> subjects, Double hourly_salary) {
        this.setName(name);
        this.setSurName(surName);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setJojningDate(jojningDate);
        this.setSubjects(subjects);
        this.setHourly_salary(hourly_salary);
        tutorList.add(this);
    }

    public Tutor(String name, String surName, LocalDate birthDate, String email, LocalDate jojningDate, Set<String> subjects, Double hourly_salary) {
        this.setName(name);
        this.setSurName(surName);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setJojningDate(jojningDate);
        this.setSubjects(subjects);
        this.setHourly_salary(hourly_salary);
        tutorList.add(this);
    }

    public double getInternship_bonus() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented yet");
    }

    public static List<Tutor> FindTutorsBySubject(String subject) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented yet");
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + Objects.requireNonNullElse(this.phoneNumber, "non") + '\'' +
                ", jojningDate=" + jojningDate +
                ", subjects=" + subjects +
                ", hourly_salary=" + hourly_salary +
                '}';
    }

    //metoda save all to file serizable
    public static Set<Tutor> getTutorList() {
        return new HashSet<>(tutorList);
    }

    public static Set<String> getSubjectList() {
        return new HashSet<>(subjectList);
    }

    public static void setSubjectList(Set<String> subjectList) {
        if (subjectList == null)
            throw new AttributeConstraintViolationException("Subject can not by null");
        for (String subject: subjectList) {
            if (subject == null)
                throw new AttributeConstraintViolationException("Subject can not by null");
            if (subject.isEmpty())
                throw new AttributeConstraintViolationException("Subject can not by empty");
        }
        Tutor.subjectList = subjectList;
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

    public Set<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<String> subjects) {
        if (subjects == null)
            throw new AttributeConstraintViolationException("Subjects can not by null");
        if (subjects.isEmpty())
            throw new AttributeConstraintViolationException("Subjects can not by empty");
        if (!Tutor.getSubjectList().containsAll(subjects))
            throw new AttributeConstraintViolationException("Some subjects are not in the subject list");
        this.subjects = subjects;
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
