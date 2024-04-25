package model;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Competition implements Serializable {

    private LocalDate date;
    private String address;
    private String name;
    private Subject subject;
    private Set<Student> participants = new HashSet<>();

    public Competition(LocalDate date, String address, String name) {
        this.setDate(date);
        this.setAddress(address);
        this.setName(name);
        EkstensjaClass.addCompetition(this);
    }

    public void setSubject(Subject subject){
        if(this.subject == subject) {
            return;
        }

        this.subject.removeCompetition(this);
        if (subject != null) {
            subject.addCompetition(this);
        }

        this.subject = subject;
    }

    public void removeSubject(Subject subject){
        if (this.subject != subject)
            return;
        this.subject.removeCompetition(this);
        this.subject = null;
    }

    public void addParticipant(Student s){
        if (participants.contains(s))
            return;
        this.participants.add(s);
        s.addCompetition(this);
    }

    public void removeParticipant(Student s){
        if (!participants.contains(s))
            return;
        this.participants.remove(s);
        s.removeCompetition(this);
    }

    public Set<Student> getParticipants() {
        return Collections.unmodifiableSet(participants);
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null)
            throw new AttributeConstraintViolationException("Date can not by null");
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null)
            throw new AttributeConstraintViolationException("Address can not by null");
        if (address.isEmpty())
            throw new AttributeConstraintViolationException("Address can not by empty");
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            throw new AttributeConstraintViolationException("Name can not by null");
        if (name.isEmpty())
            throw new AttributeConstraintViolationException("Name can not by empty");
        if (EkstensjaClass.getCompetitionList().stream().filter(competition -> name.equals(competition.getName())).findAny().orElse(null)!=null)
            throw new AttributeConstraintViolationException("The name must be unique");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "date=" + date +
                ", adress='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
