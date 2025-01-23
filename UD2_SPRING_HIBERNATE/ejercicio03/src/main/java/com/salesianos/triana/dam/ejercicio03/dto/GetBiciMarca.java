package com.salesianos.triana.dam.ejercicio03.dto;


import com.salesianos.triana.dam.ejercicio03.model.Bicicleta;

public record GetBiciMarca (
        Long id,
        String marca
) {
    public static GetBiciMarca fromBicicleta(Bicicleta bici) {
        return new GetBiciMarca(bici.getId(), bici.getMarca());
    }
}
