package com.salesianostriana.dam.colegio.dto;

import com.salesianostriana.dam.colegio.model.Alumno;

import java.time.LocalDate;
import java.util.List;

public record GetAlumnoDto(
        long id,
        String nombreCompleto,
        int edadA31Diciembre,
        List<String> asignaturas
) {

    public static GetAlumnoDto of (Alumno alumno) {

        return new GetAlumnoDto(
                alumno.getCodAlumno(),
                alumno.getNombre() + " "
                + alumno.getApellidos(),
                LocalDate.now().getYear() -
                        alumno.getFechaNac().getYear(),
                alumno.getNotas().stream()
                        .map(matriculaNotas -> matriculaNotas.getAsignatura().getNombre())
                        .toList()
        );
    }
}
