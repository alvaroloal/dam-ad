package com.salesianostriana.dam.colegio_lorentealmanalvaro.dto;


import lombok.Data;
import java.util.List;

@Data
public class AlumnoDTO {
    private Long id;
    private String nombreCompleto;
    private int edadA31Diciembre;
    private List<String> asignaturas;
}
