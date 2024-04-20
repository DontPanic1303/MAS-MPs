package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Competition implements Serializable {

    private LocalDate date;
    private String adress;
    private String name;

    public Competition(LocalDate date, String adress, String name) {
        this.date = date;
        this.adress = adress;
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "date=" + date +
                ", adress='" + adress + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
