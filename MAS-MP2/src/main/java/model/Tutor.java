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

//    private static Set<Tutor> tutorList = new HashSet<>();

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

    public Tutor(String name, String surName, LocalDate birthDate, String email, String phoneNumber, LocalDate jojningDate, Set<String> subjects, Double hourly_salary) {
        this.setName(name);
        this.setSurName(surName);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setJojningDate(jojningDate);
//        this.setSubjects(subjects);
        this.setHourly_salary(hourly_salary);
        this.setPhoneNumber(phoneNumber);
        EkstensjaClass.addTutor(this);
    }

    public Tutor(String name, String surName, LocalDate birthDate, String email, LocalDate jojningDate, Set<String> subjects, Double hourly_salary) {
        this.setName(name);
        this.setSurName(surName);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setJojningDate(jojningDate);
//        this.setSubjects(subjects);
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

//    public static Set<Tutor> FindTutorsBySubject(String subject) {
//        var tutorsToTeturn = new HashSet<Tutor>();
//
//        for (Tutor tutor: Tutor.getTutorList()) {
//            for (String sub: tutor.getSubjects()) {
//                if (sub.equals(subject)) {
//                    tutorsToTeturn.add(tutor);
//                    break;
//                }
//            }
//        }
//        return tutorsToTeturn;
//    }

//    public static void saveExtensjaToFile() {
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
//            outputStream.writeObject(tutorList);
//            System.out.println("All tutors saved to file");
//        } catch (IOException e) {
//            System.err.println("Error on saved: " + e.getMessage());
//        }
//    }
//
//    public static void loadExtensjaFromFile() {
//        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
//            tutorList = (Set<Tutor>) inputStream.readObject();
//            System.out.println("All tutors loaded from file");
//        } catch (FileNotFoundException e) {
//            System.err.println("File do not exists");
//        } catch (IOException | ClassNotFoundException e) {
//            System.err.println("Error on saved: " + e.getMessage());
//        }
//    }

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

    //metoda save all to file serizable
//    public static List<Tutor> getTutorList() {
//        return Collections.unmodifiableList(new ArrayList<>(tutorList));
//    }

    public void addSubject(Subject s){
        this.subjects.add(s);
    }

    public void removeSubject(Subject s){
        this.subjects.remove(s);
    }

    public Set<Subject> getSubjects() {
        return Collections.unmodifiableSet(subjects);
    }

    public void addLesson(Lesson l){
        this.lessons.add(l);
    }

    public void removeLesson(Lesson l){
        this.lessons.remove(l);
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

//    public Set<String> getSubjects() {
//        return Collections.unmodifiableSet(subjects);
//    }
//
//    public void setSubjects(Set<String> subjects) {
//        if (subjects == null)
//            throw new AttributeConstraintViolationException("Subjects can not by null");
//        if (subjects.isEmpty())
//            throw new AttributeConstraintViolationException("Subjects can not by empty");
//        for (String subject: subjects) {
//            if (subject == null)
//                throw new AttributeConstraintViolationException("Subject can not by null");
//            if (subject.isEmpty())
//                throw new AttributeConstraintViolationException("Subject can not by empty");
//        }
//        this.subjects = subjects;
//    }
//
//    public void addSubject(String subject){
//        if (subject == null)
//            throw new AttributeConstraintViolationException("Subjects can not by null");
//        if (subject.isEmpty())
//            throw new AttributeConstraintViolationException("Subjects can not by empty");
//        if (this.subjects.contains(subject))
//            throw new AttributeConstraintViolationException("Subjects already exists in set");
//        var updatedSubjects = new HashSet<>(this.subjects);
//        updatedSubjects.add(subject);
//        this.subjects = updatedSubjects;
//    }
//
//    public void removeSubject(String subject){
//        if (subject == null)
//            throw new AttributeConstraintViolationException("Subjects can not by null");
//        if (subject.isEmpty())
//            throw new AttributeConstraintViolationException("Subjects can not by empty");
//        if (!this.subjects.contains(subject))
//            throw new AttributeConstraintViolationException("Subjects not exists in set");
//        if (this.subjects.size()<2)
//            throw new MinimalSetSizeException("The number of subjects can not by less that one");
//        var updatedSubjects = new HashSet<>(this.subjects);
//        updatedSubjects.remove(subject);
//        this.subjects = updatedSubjects;
//    }
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
