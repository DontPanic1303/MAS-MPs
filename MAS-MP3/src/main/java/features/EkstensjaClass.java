package features;

import exceptions.AttributeConstraintViolationException;
import model.*;
import model.dynamicInheritance.Lucznik;
import model.dynamicInheritance.Wojownik;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EkstensjaClass {

    private static Set<Tutor> tutorList = new HashSet<>();
    private static Set<Subject> subjectList = new HashSet<>();
    private static Set<Lesson> lessonList = new HashSet<>();
    private static Set<Student> studentList = new HashSet<>();
    private static Set<Comment> commentList = new HashSet<>();
    private static Set<Competition> competitionList = new HashSet<>();

    private static Set<Offline> offlineList = new HashSet<>();
    private static Set<Online> onlineList = new HashSet<>();

    private static Set<Wojownik> wojownikList = new HashSet<>();

    private static Set<Lucznik> lucznikList = new HashSet<>();


    public static void save(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tutorList);
            oos.writeObject(subjectList);
            oos.writeObject(lessonList);
            oos.writeObject(studentList);
            oos.writeObject(commentList);
            oos.writeObject(competitionList);
            oos.writeObject(offlineList);
            oos.writeObject(onlineList);
            oos.writeDouble(Tutor.getMinimalHourlySalary());
        }
    }


    public static void load(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            tutorList = (Set<Tutor>) ois.readObject();
            subjectList = (Set<Subject>) ois.readObject();
            lessonList = (Set<Lesson>) ois.readObject();
            studentList = (Set<Student>) ois.readObject();
            commentList = (Set<Comment>) ois.readObject();
            competitionList = (Set<Competition>) ois.readObject();
            offlineList = (Set<Offline>) ois.readObject();
            onlineList = (Set<Online>) ois.readObject();
            Tutor.setMinimalHourlySalary(ois.readDouble());
        }
    }

    public static Set<Wojownik> getWojownikList() {
        return Collections.unmodifiableSet(wojownikList);
    }

    public static Set<Lucznik> getLucznikList() {
        return Collections.unmodifiableSet(lucznikList);
    }

    public static Set<Tutor> getTutorList() {
        return Collections.unmodifiableSet(tutorList);
    }

    public static Set<Subject> getSubjectList() {
        return Collections.unmodifiableSet(subjectList);
    }

    public static Set<Lesson> getLessonList() {
        return Collections.unmodifiableSet(lessonList);
    }

    public static Set<Student> getStudentList() {
        return Collections.unmodifiableSet(studentList);
    }

    public static Set<Comment> getCommentList() {
        return Collections.unmodifiableSet(commentList);
    }

    public static Set<Competition> getCompetitionList() {
        return Collections.unmodifiableSet(competitionList);
    }

    public static Set<Offline> getOfflineList() {
        return Collections.unmodifiableSet(offlineList);
    }

    public static Set<Online> getOnlineList() {
        return Collections.unmodifiableSet(onlineList);
    }

    public static void addWojownik(Wojownik wojownik){
        if (wojownik == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (wojownikList.contains(wojownik))
            throw new AttributeConstraintViolationException("Comment already exists in set");
        wojownikList.add(wojownik);
    }

    public static void removeWojownik(Wojownik wojownik){
        if (wojownik == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (!wojownikList.contains(wojownik))
            return;
        wojownikList.remove(wojownik);
    }

    public static void addLucznik(Lucznik lucznik){
        if (lucznik == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (lucznikList.contains(lucznik))
            throw new AttributeConstraintViolationException("Comment already exists in set");
        lucznikList.add(lucznik);
    }

    public static void removeLucznik(Lucznik lucznik){
        if (lucznik == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (!lucznikList.contains(lucznik))
            return;
        lucznikList.remove(lucznik);
    }

    public static void addOffline(Offline offline){
        if (offline == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (offlineList.contains(offline))
            throw new AttributeConstraintViolationException("Comment already exists in set");
        offlineList.add(offline);
    }

    public static void removeOffline(Offline offline){
        if (offline == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (!offlineList.contains(offline))
            return;
        offlineList.remove(offline);
    }

    public static void addOnline(Online online){
        if (online == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (onlineList.contains(online))
            throw new AttributeConstraintViolationException("Comment already exists in set");
        onlineList.add(online);
    }

    public static void removeOnline(Online online){
        if (online == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (!onlineList.contains(online))
            return;
        onlineList.remove(online);
    }

    public static void addComment(Comment comment){
        if (comment == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (commentList.contains(comment))
            throw new AttributeConstraintViolationException("Comment already exists in set");
        commentList.add(comment);
    }

    public static void removeComment(Comment comment){
        if (comment == null)
            throw new AttributeConstraintViolationException("Comment can not by null");
        if (!commentList.contains(comment))
            return;
        commentList.remove(comment);
    }

    public static void addCompetition(Competition competition){
        if (competition == null)
            throw new AttributeConstraintViolationException("Competition can not by null");
        if (competitionList.contains(competition))
            throw new AttributeConstraintViolationException("Competition already exists in set");
        competitionList.add(competition);
    }

    //for test
    public static void cleanCompetition(){
        competitionList = new HashSet<>();
    }

    public static void addLesson(Lesson lesson){
        if (lesson == null)
            throw new AttributeConstraintViolationException("Lesson can not by null");
        if (lessonList.contains(lesson))
            throw new AttributeConstraintViolationException("Lesson already exists in set");
        lessonList.add(lesson);
    }

    public static void removeLesson(Lesson lesson){
        if (lesson == null)
            throw new AttributeConstraintViolationException("Lesson can not by null");
        if (!lessonList.contains(lesson))
            return;
        lessonList.remove(lesson);
    }
    public static void addStudent(Student student){
        if (student == null)
            throw new AttributeConstraintViolationException("Student can not by null");
        if (studentList.contains(student))
            throw new AttributeConstraintViolationException("Student already exists in set");
        studentList.add(student);
    }

    public static void addSubject(Subject subject){
        if (subject == null)
            throw new AttributeConstraintViolationException("Subject can not by null");
        if (subjectList.contains(subject))
            throw new AttributeConstraintViolationException("Subject already exists in set");
        subjectList.add(subject);
    }

    public static void addTutor(Tutor tutor){
        if (tutor == null)
            throw new AttributeConstraintViolationException("Tutor can not by null");
        if (tutorList.contains(tutor))
            throw new AttributeConstraintViolationException("Tutor already exists in set");
        tutorList.add(tutor);
    }


}



