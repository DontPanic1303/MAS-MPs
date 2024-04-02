package model;

import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Tutor {

    private static List<Tutor> tutorList = new ArrayList<>();

    private static Set<String> subjectList;
    private String name;
    private String surName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private LocalDate jojningDate;
    private Set<String> subjects;
    private Double hourly_salary;
    private static double minimalHourlySalary;

    public Tutor(String name, String surName, LocalDate birthDate, String email, String phoneNumber, LocalDate jojningDate, Set<String> subjects, Double hourly_salary) {
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jojningDate = jojningDate;
        this.subjects = subjects;
        this.hourly_salary = hourly_salary;
    }

    public Tutor(String name, String surName, LocalDate birthDate, String email, LocalDate jojningDate, Set<String> subjects, Double hourly_salary) {
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.email = email;
        this.jojningDate = jojningDate;
        this.subjects = subjects;
        this.hourly_salary = hourly_salary;
    }

    public double internship_bonus() throws ExecutionControl.NotImplementedException {
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
                ", phoneNumber='" + phoneNumber + '\'' +
                ", jojningDate=" + jojningDate +
                ", subjects=" + subjects +
                ", hourly_salary=" + hourly_salary +
                '}';
    }

    public static List<Tutor> getTutorList() {
        return tutorList;
    }

    public static Set<String> getSubjectList() {
        return subjectList;
    }

    public static void setSubjectList(Set<String> subjectList) {
        Tutor.subjectList = subjectList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getJojningDate() {
        return jojningDate;
    }

    public Set<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<String> subjects) {
        this.subjects = subjects;
    }

    public double getHourly_salary() {
        return hourly_salary;
    }

    public void setHourly_salary(Double hourly_salary) {
        this.hourly_salary = hourly_salary;
    }

    public static double getMinimalHourlySalary() {
        return minimalHourlySalary;
    }

    public static void setMinimalHourlySalary(double minimalHourlySalary) {
        Tutor.minimalHourlySalary = minimalHourlySalary;
    }


}
