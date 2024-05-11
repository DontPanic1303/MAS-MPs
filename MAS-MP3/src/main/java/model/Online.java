package model;

import java.time.LocalDate;

public class Online extends Competition{

    private String link;

    public Online(LocalDate date, String address, String name) {
        super(date, address, name);
    }
}
