package edu.pjatk.mas.s25278.masmp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(1)
    @NotNull
    private int days;

    @NotNull
    private LocalDate startTime;

    @ManyToOne
    @JoinColumn(name = "Administrator_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Administrator imposedBy;

    @ManyToOne
    @JoinColumn(name = "Person_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person imposedOn;

}
