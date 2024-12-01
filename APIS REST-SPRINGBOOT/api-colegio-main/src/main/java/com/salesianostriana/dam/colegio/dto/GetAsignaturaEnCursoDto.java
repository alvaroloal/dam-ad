package com.salesianostriana.dam.colegio.dto;

import com.salesianostriana.dam.colegio.model.Asignatura;
import com.salesianostriana.dam.colegio.model.MatriculaNotas;

public record GetAsignaturaEnCursoDto(
        long id,
        String nombre,
        int numHoras,
        int cantidadAlumnos
) {

    public static GetAsignaturaEnCursoDto of(Asignatura asignatura) {

        return new GetAsignaturaEnCursoDto(
                asignatura.getId(),
                asignatura.getNombre(),
                asignatura.getNumHoras(),
                asignatura.getNotas().size()
        );
    }
}
