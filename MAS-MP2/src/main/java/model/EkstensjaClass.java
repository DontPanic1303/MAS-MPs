package model;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class EkstensjaClass {

    private static Set<Tutor> tutorList = new HashSet<>();
    private static Set<Subject> subjectList = new HashSet<>();
    private static Set<Lesson> lessonList = new HashSet<>();
    private static Set<Student> studentList = new HashSet<>();
    private static Set<Coment> comentList = new HashSet<>();
    private static Set<Competition> competitionList = new HashSet<>();


    public static void save(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tutorList);
            oos.writeObject(subjectList);
            oos.writeObject(lessonList);
            oos.writeObject(studentList);
            oos.writeObject(comentList);
            oos.writeObject(competitionList);
        }
    }


    public static void load(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            tutorList = (Set<Tutor>) ois.readObject();
            subjectList = (Set<Subject>) ois.readObject();
            lessonList = (Set<Lesson>) ois.readObject();
            studentList = (Set<Student>) ois.readObject();
            comentList = (Set<Coment>) ois.readObject();
            competitionList = (Set<Competition>) ois.readObject();
        }
    }

}



