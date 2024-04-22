package model;

import exceptions.AttributeConstraintViolationException;
import features.EkstensjaClass;

import javax.naming.Name;
import java.io.Serializable;

public class Subject implements Serializable {
    private String name;
    private String level;

    public Subject(String name, String level) {
        this.setName(name);
        this.setLevel(level);
        EkstensjaClass.addSubject(this);
    }

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        if (level == null)
            throw new AttributeConstraintViolationException("Level can not by null");
        if (level.isEmpty())
            throw new AttributeConstraintViolationException("Level can not by empty");
        this.level = level;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
