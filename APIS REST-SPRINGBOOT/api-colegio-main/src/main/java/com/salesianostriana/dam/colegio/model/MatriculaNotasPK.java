package com.salesianostriana.dam.colegio.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class MatriculaNotasPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long alumno_id;
    private Long asignatura_id;
}
