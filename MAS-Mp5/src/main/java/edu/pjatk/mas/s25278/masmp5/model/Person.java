package edu.pjatk.mas.s25278.masmp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

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
}
