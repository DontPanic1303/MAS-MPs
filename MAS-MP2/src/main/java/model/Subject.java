package model;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import javax.naming.Name;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Subject implements Serializable {
    private String name;
    private String level;
    private Set<Tutor> tutors = new HashSet<>();
    private Set<Competition> competitions = new HashSet<>();

    public Subject(String name, String level) {
        this.setName(name);
        this.setLevel(level);
        EkstensjaClass.addSubject(this);
    }

    public void addTutor(Tutor t){
        if (t == null)
            throw new IllegalArgumentException("Tutor can not be null");
        if (tutors.contains(t))
            return;
        this.tutors.add(t);
        t.addSubject(this);
    }

    public void removeTutor(Tutor t){
        if (t == null)
            throw new IllegalArgumentException("Tutor can not be null");
        if (!tutors.contains(t))
            return;
        this.tutors.remove(t);
        t.removeSubject(this);
    }

    public Set<Tutor> getTutors() {
        return Collections.unmodifiableSet(tutors);
    }

    public void addCompetition(Competition c){
        if (c == null)
            throw new IllegalArgumentException("Competition can not be null");
        if (competitions.contains(c))
            return;
        this.competitions.add(c);
        c.setSubject(this);
    }

    public void removeCompetition(Competition c){
        if (c == null)
            throw new IllegalArgumentException("Competition can not be null");
        if (!competitions.contains(c))
            return;
        this.competitions.remove(c);
        c.removeSubject(this);
    }

    public Set<Competition> getCompetitions() {
        return Collections.unmodifiableSet(competitions);
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        if (level == null)
            throw new AttributeConstraintViolationException("Level can not by null");
        if (level.isEmpty())
            throw new AttributeConstraintViolationException("Level can not by empty");
        this.level = level;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
