package com.salesianostriana.dam.lorentealmanalvaromonumentos.dto;

import com.salesianostriana.dam.lorentealmanalvaromonumentos.model.Monumento;

public record CreateMonumentoDto(
        Long id,
        String codPais,
        String nombrePais,
        String nombreCiudad,
        double latitud,
        double longitud,
        String nombreMonumento,
        String descripcion,
        String fotoUrl
) {

    public Monumento toMonumento() {
        return new Monumento(null, this.codPais, this.nombrePais, this.nombreCiudad, this.latitud, this.longitud, this.nombreMonumento, this.descripcion, this.fotoUrl);
    }

}
