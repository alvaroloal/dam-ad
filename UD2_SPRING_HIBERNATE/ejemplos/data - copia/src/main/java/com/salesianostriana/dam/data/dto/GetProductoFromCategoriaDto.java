package com.salesianostriana.dam.data.dto;

import com.salesianostriana.dam.data.model.Producto;

public record GetProductoFromCategoriaDto (
        Long id,
        String nombre,
        double precio
){

    public static GetProductoFromCategoriaDto of (Producto producto) {

        return new GetProductoFromCategoriaDto(
                producto.getId(),
                producto.getNombreProducto(),
                producto.getPrecioVenta()
        );
    }
}
