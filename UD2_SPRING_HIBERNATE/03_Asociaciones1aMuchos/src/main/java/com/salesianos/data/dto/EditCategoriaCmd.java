package com.salesianos.data.dto;

public record EditCategoriaCmd(
        String nombre,
        Long productoId
) {
}
