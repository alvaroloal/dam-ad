package com.salesianostriana.dam.colegio_lorentealmanalvaro.dto;

import lombok.Data;
import java.util.List;

@Data
public class CursoDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private int horasTotales;
    private List<AsignaturaDTO> asignaturas;
}

@Data
class AsignaturaDTO {
    private Long id;
    private String nombre;
    private int numHoras;
    private int cantidadAlumnos;
}
 
