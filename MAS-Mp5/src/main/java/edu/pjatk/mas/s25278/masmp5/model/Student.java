package edu.pjatk.mas.s25278.masmp5.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public class Student extends Person{

    @ManyToMany
    @MapKey(name = "name")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Map<String, Competition> participates = new HashMap<>();

    @OneToMany(mappedBy = "student", cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Lesson> lessons;



}
