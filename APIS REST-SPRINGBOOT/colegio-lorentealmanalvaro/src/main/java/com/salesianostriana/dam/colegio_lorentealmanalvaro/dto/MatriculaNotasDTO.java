package com.salesianostriana.dam.colegio_lorentealmanalvaro.dto;

import lombok.Data;

@Data
public class MatriculaNotasDTO {
    private int año;
    private double nota;
    private Long alumnoId;
    private Long asignaturaId;
}

