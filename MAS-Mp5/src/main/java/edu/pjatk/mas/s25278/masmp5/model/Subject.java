package edu.pjatk.mas.s25278.masmp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2,max = 255)
    private String name;

    @NotBlank(message = "Level is mandatory")
    @Size(min = 2,max = 255)
    private String level;
}
