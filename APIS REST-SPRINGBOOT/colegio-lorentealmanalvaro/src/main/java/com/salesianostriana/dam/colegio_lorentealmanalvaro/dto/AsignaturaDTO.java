package com.salesianostriana.dam.colegio_lorentealmanalvaro.dto;

import lombok.Data;

@Data
public class AsignaturaDTO {
    private Long id;
    private String nombre;
    private int numHoras;
    private String contenidos;
    private Long cursoId;
}

