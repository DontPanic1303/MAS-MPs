package edu.pjatk.mas.s25278.masmp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Online {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Link is mandatory")
    private String link;

    @OneToOne(optional = false)
    @JoinColumn(name = "competition_id", nullable = false, updatable = false)
    private Competition competition;

}
