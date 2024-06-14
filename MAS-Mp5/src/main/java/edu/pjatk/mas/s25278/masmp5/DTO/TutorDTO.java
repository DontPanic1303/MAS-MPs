package edu.pjatk.mas.s25278.masmp5.DTO;

public class TutorDTO {

    private Long id;

    private String name;

    private String surname;

    private double hourlySalary;

    public TutorDTO(Long id, String name, String surname, double hourlySalary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.hourlySalary = hourlySalary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
