package com.salesianos.triana.dam.ejercicio03.dto;


import com.salesianos.triana.dam.ejercicio03.model.Estacion;

public record GetEstacionDto(
        Long id,
        String nombre
) {

    public static GetEstacionDto of(Estacion estacion) {
        return new GetEstacionDto(estacion.getId(), estacion.getNombre());
    }

}
