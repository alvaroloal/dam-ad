package com.salesianostriana.dam.data.dto;

import com.salesianostriana.dam.data.model.Categoria;

import java.util.List;

public record GetCategoriaWithProducto(
        Long id,
        String nombre,
        List<GetProductoFromCategoriaDto> productos
) {


    public static GetCategoriaWithProducto of (Categoria categoria) {

        return new GetCategoriaWithProducto(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getProductos()
                        .stream()
                        .map(GetProductoFromCategoriaDto::of)
                        .toList()
        );
    }
}
