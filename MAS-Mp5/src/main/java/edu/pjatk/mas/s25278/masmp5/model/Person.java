package edu.pjatk.mas.s25278.masmp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2,max = 255)
    private String name;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2,max = 255)
    private String surName;

    @NotNull
    private LocalDate birthDate;

    @NotBlank(message = "Name is mandatory")
    @Email
    private String email;

    @OneToMany(mappedBy = "imposedOn")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Ban> bans = new HashSet<>();

    @OneToMany(mappedBy = "accused")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Complain> complainsAccused = new HashSet<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Complain> complainsAuthor = new HashSet<>();
}
