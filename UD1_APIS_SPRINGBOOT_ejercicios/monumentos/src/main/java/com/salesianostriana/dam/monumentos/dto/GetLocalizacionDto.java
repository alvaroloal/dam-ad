package com.salesianostriana.dam.monumentos.dto;

public record GetLocalizacionDto(
        double latitud,
        double longitud
) {

    public static GetLocalizacionDto of(double latitud, double longitud) {

        return new GetLocalizacionDto(
                latitud,
                longitud
        );
    }
}
