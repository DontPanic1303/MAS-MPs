package edu.pjatk.mas.s25278.masmp5.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Map<String, Competition> participates = new HashMap<>();

    @OneToMany(mappedBy = "student", cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Lesson> lessons;



}
