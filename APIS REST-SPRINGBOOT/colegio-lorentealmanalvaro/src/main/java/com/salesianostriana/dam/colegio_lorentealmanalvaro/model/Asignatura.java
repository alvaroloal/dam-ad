package com.salesianostriana.dam.colegio_lorentealmanalvaro.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int numHoras;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatriculaNotas> matriculas = new ArrayList<>();

    public Asignatura(String nombre, int numHoras) {
        this.nombre = nombre;
        this.numHoras = numHoras;
    }

    public void agregarMatricula(MatriculaNotas matricula) {
        matriculas.add(matricula);
        matricula.setAsignatura(this);
    }
}

