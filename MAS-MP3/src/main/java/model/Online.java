package model;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import java.io.Serializable;
import java.time.LocalDate;

public class Online implements Serializable {

    private String link;

    private Competition competition;

    public Online(Competition competition, String link) {
        this.setLink(link);
        if (competition == null)
            throw new IllegalArgumentException("Commentator can not by null");
        this.competition=competition;
        EkstensjaClass.addOnline(this);
//        competition.setOnline(this);
    }

    public void delete(){
//        competition.setOnline(null);
        EkstensjaClass.removeOnline(this);
        this.competition = null;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        if (link == null)
            throw new AttributeConstraintViolationException("Address can not by null");
        if (link.isEmpty())
            throw new AttributeConstraintViolationException("Address can not by empty");
        this.link = link;
    }

    public Competition getCompetition() {
        return competition;
    }
}
