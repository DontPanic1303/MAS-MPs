package edu.pjatk.mas.s25278.masmp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Complain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Content is mandatory")
    private String content;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotNull
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "accused_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person accused;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    private Person author;



}
