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
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDate date;

    @NotBlank(message = "Name is mandatory")
    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "Subject_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Subject subject;


}
