package com.salesianostriana.dam.colegio.dto;

import com.salesianostriana.dam.colegio.model.Asignatura;
import com.salesianostriana.dam.colegio.model.Curso;

import java.util.List;

public record GetCursoDto(
        long id,
        String nombre,
        String tipo,
        long horasTotales,
        List<GetAsignaturaEnCursoDto> asignaturas

) {

    public static GetCursoDto of (Curso curso) {

        String tipo = curso.getTipo().toString().toLowerCase();
        String formateado = tipo.substring(0, 1)
                .toUpperCase()
                + tipo.substring(1);
        return new GetCursoDto(
                curso.getId(),
                curso.getNombre(),
                formateado,
                curso.getAsignaturas()
                        .stream()
                        .mapToLong(Asignatura::getNumHoras)
                        .sum(),
                curso.getAsignaturas()
                        .stream()
                        .map(GetAsignaturaEnCursoDto::of)
                        .toList()

        );
    }
}
