package com.salesianostriana.dam.colegio_lorentealmanalvaro.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public void agregarAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
        asignatura.setCurso(this);
    }
}




