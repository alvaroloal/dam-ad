package com.salesianostriana.dam.monumentos.dto;

import com.salesianostriana.dam.monumentos.model.Monumento;

public record CreateMonumentoDto(
        String codigoPais,
        String nombrePais,
        String nombreCiudad,
        double latitud,
        double longitud,
        String nombreMonumento,
        String descripcion,
        String photoUrl
) {

    public Monumento toMonumento() {

        return Monumento.builder()
                .codigoPais(this.codigoPais)
                .nombrePais(this.nombrePais)
                .nombreCiudad(this.nombreCiudad)
                .latitud(this.latitud)
                .longitud(this.longitud)
                .nombreMonumento(this.nombreMonumento)
                .descripcion(this.descripcion)
                .photoUrl(this.photoUrl)
                .build();
    }
}
