package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.Place;

public record GetPlaceDto(
        Long id,
        String nombre,
        String coordenadas,
        String imagen
) {

    public static GetPlaceDto of (Place place) {

        return new GetPlaceDto(
                place.getId(),
                place.getName(),
                place.getCoords(),
                place.getImage()
        );
    }
}
