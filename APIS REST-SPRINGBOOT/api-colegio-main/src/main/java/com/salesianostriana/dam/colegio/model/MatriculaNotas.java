package com.salesianostriana.dam.colegio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MatriculaNotas {

    @EmbeddedId
    private MatriculaNotasPK notasPK = new MatriculaNotasPK();

    @ManyToOne
    @MapsId("alumno_id")
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @MapsId("asignatura_id")
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    private Long anio;

    private double nota;




    //HELPER

    public void addToAlumno(Alumno alumno) {

        alumno.getNotas().add(this);

        this.alumno = alumno;
    }

    public void removeFromAlumno(Alumno alumno) {

        alumno.getNotas().remove(this);

        this.alumno = null;
    }
}
