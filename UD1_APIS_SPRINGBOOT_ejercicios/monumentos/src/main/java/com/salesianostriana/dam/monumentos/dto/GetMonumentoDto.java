package com.salesianostriana.dam.monumentos.dto;

import com.salesianostriana.dam.monumentos.model.Monumento;

public record GetMonumentoDto(
        Long id,
        String codigoPais,
        String nombrePais,
        String nombreCiudad,
        GetLocalizacionDto localizacionDto,
        String nombreMonumento,
        String descripcion,
        String photoUrl
) {

    public static GetMonumentoDto of (Monumento monumento){

        return new GetMonumentoDto(
                monumento.getId(),
                monumento.getCodigoPais(),
                monumento.getNombrePais(),
                monumento.getNombreCiudad(),
                GetLocalizacionDto.of(monumento.getLatitud(), monumento.getLongitud()),
                monumento.getNombreMonumento(),
                monumento.getDescripcion(),
                monumento.getPhotoUrl()
        );
    }
}
