package com.salesianostriana.dam.colegio_lorentealmanalvaro.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class MatriculaNotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int año;
    private double nota;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    public MatriculaNotas(int año, double nota) {
        this.año = año;
        this.nota = nota;
    }
}
