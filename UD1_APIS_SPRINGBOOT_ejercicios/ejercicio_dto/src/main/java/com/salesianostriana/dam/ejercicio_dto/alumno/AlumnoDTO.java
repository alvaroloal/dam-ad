package com.salesianostriana.dam.ejercicio_dto.alumno;

public record AlumnoDTO(
        String nombre,
        String apellidos,
        String email,
        String curso,
        String direccion
) {

    public static AlumnoDTO of (Alumno alumno) {

        return new AlumnoDTO(
                alumno.getNombre(),
                alumno.getApellido1() + " " + alumno.getApellido2(),
                alumno.getEmail(),
                alumno.getCurso().getNombre(),
                alumno.getDireccion().getTipoVia() + " "
                        + alumno.getDireccion().getLinea1() + " " +
                        alumno.getDireccion().getLinea2() + ", "
                        + alumno.getDireccion().getCp() + ", " +
                        alumno.getDireccion().getPoblacion() +
                        ", " + alumno.getDireccion().getProvincia()
        );
    }
}

