package com.salesianostriana.dam.colegio_lorentealmanalvaro.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAlumno;

    private String nombre;
    private String apellidos;
    private LocalDate fechaNac;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatriculaNotas> matriculas = new ArrayList<>();

    public Alumno(String nombre, String apellidos, LocalDate fechaNac) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
    }

    public void agregarMatricula(MatriculaNotas matricula) {
        matriculas.add(matricula);
        matricula.setAlumno(this);
    }
}
 