package edu.pjatk.mas.s25278.masmp5.DTO;

import java.util.Objects;

public class SubjectDTO {
    private Long id;
    private String name;
    private String level;

    public SubjectDTO(Long id, String name, String level) {
        this.id = id;
        this.name = name;
        if (Objects.equals(level, "Srednio_Zawansowany"))
            this.level = "Średnio Zawansowany";
        else
            this.level = level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}