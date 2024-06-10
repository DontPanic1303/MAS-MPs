package edu.pjatk.mas.s25278.masmp5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Administrator extends Person{

    @NotNull
    @Min(0)
    private int salary;

    @OneToMany(mappedBy = "imposedBy")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Ban> bans = new HashSet<>();

}
