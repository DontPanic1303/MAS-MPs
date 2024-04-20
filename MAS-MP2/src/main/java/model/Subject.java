package model;

import javax.naming.Name;
import java.io.Serializable;

public class Subject implements Serializable {
    private String name;
    private String level;

    public Subject(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
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
