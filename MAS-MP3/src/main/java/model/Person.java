package model;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {

    private String name;
    private String surName;
    private LocalDate birthDate;
    private String email;

    public Person(String name, String surName, LocalDate birthDate, String email) {
        this.setName(name);
        this.setSurName(surName);
        this.setBirthDate(birthDate);
        this.setEmail(email);
    }

    public abstract double payment();

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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if (surName == null)
            throw new AttributeConstraintViolationException("Surname can not by null");
        if (surName.isEmpty())
            throw new AttributeConstraintViolationException("Surname can not by empty");
        this.surName = surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null)
            throw new AttributeConstraintViolationException("BirthDate can not by null");
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null)
            throw new AttributeConstraintViolationException("email can not by null");
        if (email.isEmpty())
            throw new AttributeConstraintViolationException("email can not by empty");

        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches())
            throw new AttributeConstraintViolationException("email is incorrect");

        this.email = email;
    }



}
