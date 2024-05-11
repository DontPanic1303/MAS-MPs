package model;

import java.time.LocalDate;

public class Offline extends Competition{

    private String address;

    public Offline(LocalDate date, String address, String name) {
        super(date, address, name);
    }
}
