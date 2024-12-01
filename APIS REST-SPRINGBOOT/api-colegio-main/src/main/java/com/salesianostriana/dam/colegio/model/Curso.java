package com.salesianostriana.dam.colegio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @Enumerated(value = EnumType.STRING)
    private TipoCurso tipo;

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Asignatura> asignaturas = new ArrayList<>();


    //HELPER

    public void addAsignatura(Asignatura asignatura) {

        this.asignaturas.add(asignatura);
        asignatura.setCurso(this);
    }


    public void removeAsignatura(Asignatura asignatura) {

        this.asignaturas.remove(asignatura);
        asignatura.setCurso(null);
    }
}
