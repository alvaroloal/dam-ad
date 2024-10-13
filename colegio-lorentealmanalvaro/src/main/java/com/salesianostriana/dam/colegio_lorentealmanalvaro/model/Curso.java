package com.salesianostriana.dam.colegio_lorentealmanalvaro.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoCurso tipo;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignatura> asignaturas = new ArrayList<>();

    public Curso(String nombre, TipoCurso tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Método para agregar asignatura y mantener la relación bidireccional
    public void agregarAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
        asignatura.setCurso(this);
    }
}
