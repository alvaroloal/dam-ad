package com.salesianostriana.dam.ejercicio_dto.alumno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alumno {

    private Long id;
    private String nombre;
    private String apellido1,apellido2;
    private String telefono;
    private String email;
    private Direccion direccion;
    private Curso curso;
}

