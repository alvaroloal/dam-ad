package com.salesianostriana.dam.colegio.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private Integer numHoras;

    private String contenidos;

    @OneToMany(
            mappedBy = "asignatura",
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<MatriculaNotas> notas = new ArrayList<>();

    @ManyToOne
    private Curso curso;
}
