package com.salesianostriana.dam.colegio_lorentealmanalvaro.dto;


import lombok.Data;


@Data
public class AlumnoDTO {
    private Long codAlumno;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private String fechaNac;
}

