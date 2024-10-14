package com.salesianostriana.dam.colegio_lorentealmanalvaro.dto;

import lombok.Data;
import java.util.List;


@Data
public class CursoDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private List<AsignaturaDTO> asignaturas;
}







 
