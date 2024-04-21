package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Competition implements Serializable {

    private LocalDate date;
    private String address;
    private String name;

    public Competition(LocalDate date, String address, String name) {
        this.date = date;
        this.address = address;
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
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
                ", adress='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
