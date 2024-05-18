package model;

import exceptions.AttributeConstraintViolationException;
import exceptions.nonExistentClassException;
import features.EkstensjaClass;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Competition implements Serializable {

    private LocalDate date;
    private String name;
    private Subject subject;
    private Set<Student> participants = new HashSet<>();

    private Offline offline;

    private Online online;

    public Competition(LocalDate date, String name) {
        this.setDate(date);
        this.setName(name);
        EkstensjaClass.addCompetition(this);
    }

    public Competition(LocalDate date, String name, String link){
        this.setDate(date);
        this.setName(name);
        this.online = new Online(this,link);
        EkstensjaClass.addCompetition(this);
    }

    public Competition(LocalDate date, String name, String address, int numberOfSits){
        this.setDate(date);
        this.setName(name);
        this.offline = new Offline(this,address,numberOfSits);
        EkstensjaClass.addCompetition(this);
    }

    public Competition(LocalDate date, String name, String address, int numberOfSits, String link){
        this.setDate(date);
        this.setName(name);
        try {
            this.offline = new Offline(this,address,numberOfSits);
            this.online = new Online(this,link);
        } catch (Exception e) {
            if (this.offline != null)
                this.offline.delete();
            if (this.online != null)
                this.online.delete();
            throw e;
        }
        EkstensjaClass.addCompetition(this);
    }


    public void setSubject(Subject subject){
        if(this.subject == subject) {
            return;
        }

        if (subject==null){
            this.subject.removeCompetition(this);
            this.subject=null;
        }

        if (this.subject!=subject) {
            if (this.subject!=null)
                this.subject.removeCompetition(this);
            subject.addCompetition(this);
            this.subject=subject;
        }

    }

    public void setOffline(Offline offline){
        if(this.offline == offline) {
            return;
        }

        if (offline==null){
            this.offline.delete();
            this.offline=null;
        }

        if (this.offline!=offline) {
            Offline result = EkstensjaClass.getOfflineList().stream()
                    .filter(off -> off.equals(offline))
                    .findFirst().orElse(null);
            if (result == null)
                throw new IllegalArgumentException("This offline dos not exists");
            if (result.getCompetition() != this)
                throw new IllegalArgumentException("Offline can not have more that one owner");
            this.offline.delete();
            this.offline=offline;
        }

    }

    public void setOnline(Online online){
        if(this.online == online) {
            return;
        }

        if (online==null){
            this.online.delete();
            this.online=null;
        }

        if (this.online!=online) {
            Online result = EkstensjaClass.getOnlineList().stream()
                    .filter(on -> on.equals(online))
                    .findFirst().orElse(null);
            if (result == null)
                throw new IllegalArgumentException("This online dos not exists");
            if (result.getCompetition() != this)
                throw new IllegalArgumentException("Online can not have more that one owner");
            this.online.delete();
            this.online=online;
        }

    }

    public String getLink() {
        if (this.online == null)
            throw new nonExistentClassException("Online does not exists");
        return online.getLink();
    }

    public void setLink(String link) {
        if (online == null)
            throw new nonExistentClassException("Online does not exists");
        online.setLink(link);
    }

    public String getAddress() {
        if (this.offline == null)
            throw new nonExistentClassException("Offline does not exists");
        return offline.getAddress();
    }

    public void setAddress(String address) {
        if (offline == null)
            throw new nonExistentClassException("Offline does not exists");
        offline.setAddress(address);
    }

    public Offline getOffline() {
        return offline;
    }

    public Online getOnline() {
        return online;
    }

    public Subject getSubject(){
        return subject;
    }

    public void addParticipant(Student s){
        if (s == null)
            throw new IllegalArgumentException("Participant can not be null");
        if (participants.contains(s))
            return;
        this.participants.add(s);
        s.addCompetition(this);
    }

    public void removeParticipant(Student s){
        if (s == null)
            throw new IllegalArgumentException("Participant can not be null");
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
                ", name='" + name + '\'' +
                '}';
    }
}
