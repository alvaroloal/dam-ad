package com.salesianos.triana.dam.ejercicio03.dto;

import com.salesianos.triana.dam.ejercicio03.model.Bicicleta;

public record GetBiciDto (
        Long id,
        String marca,
        String modelo,
        String estado,
        GetEstacionDto estacion
){

    public static GetBiciDto of(Bicicleta bici) {
        return new GetBiciDto(bici.getId(), bici.getMarca(), bici.getModelo(), bici.getEstado(), GetEstacionDto.of(bici.getEstacion()));
    }

}
