package com.salesianostriana.dam.ejercicio_dto.producto;

public record ProductoDTO(
        String nombre,
        double pvp,
        String imagen,
        String categoria
) {

    public static ProductoDTO of (Producto producto) {

        return new ProductoDTO(
                producto.getNombre(),
                producto.getPvp(),
                producto.getImagenes().stream().findFirst().get(),
                producto.getCategoria().getNombre()
        );
    }
}

