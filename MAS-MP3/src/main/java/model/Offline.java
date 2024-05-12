package model;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import java.io.Serializable;
import java.time.LocalDate;

public class Offline implements Serializable {

    private String address;
    private int numberOfSits;
    private Competition competition;

    public Offline(Competition competition, String address, int numberOfSits) {
      this.setAddress(address);
      this.setNumberOfSits(numberOfSits);
        if (competition == null)
            throw new IllegalArgumentException("Commentator can not by null");
        this.competition=competition;
        EkstensjaClass.addOffline(this);
//        competition.setOffline(this);
    }

    public void delete(){
//        competition.setOffline(null);
        EkstensjaClass.removeOffline(this);
        this.competition = null;
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

    public int getNumberOfSits() {
        return numberOfSits;
    }

    public void setNumberOfSits(int numberOfSits) {
        if (numberOfSits <= 0.0)
            throw new AttributeConstraintViolationException("Number of sits can not by below zero");
        this.numberOfSits = numberOfSits;
    }

    public Competition getCompetition() {
        return competition;
    }
}
