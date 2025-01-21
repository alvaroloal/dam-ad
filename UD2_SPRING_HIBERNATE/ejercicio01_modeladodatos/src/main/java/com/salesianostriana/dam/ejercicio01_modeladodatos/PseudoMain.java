package com.salesianostriana.dam.ejercicio01_modeladodatos;

import com.salesianostriana.dam.ejercicio01_modeladodatos.model.Categoria;
import com.salesianostriana.dam.ejercicio01_modeladodatos.model.Producto;
import com.salesianostriana.dam.ejercicio01_modeladodatos.service.CategoriaService;
import com.salesianostriana.dam.ejercicio01_modeladodatos.service.ProductoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PseudoMain {

    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    @PostConstruct
    public void init() {

        Producto producto1 = Producto.builder()
                .nombre("iphone 15")
                .pvp(599.99)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("TV Samsung")
                .pvp(1599.99)
                .build();

        Categoria categoria1 = Categoria.builder()
                .nombre("Dispositivos móviles")
                .build();
        Categoria categoria2 = Categoria.builder()
                .nombre("Televisiones")
                .build();





        producto1.addToCategoria(categoria1);
        producto2.addToCategoria(categoria2);


        categoriaService.save(categoria1);
        productoService.save(producto1);

        categoriaService.save(categoria2);
        productoService.save(producto2);


        Categoria categoriaPadre = Categoria.builder()
                .nombre("Tecnología de consumo")
                .build();
        categoriaPadre.addHija(categoria1);
        categoriaService.save(categoriaPadre);
        categoriaService.save(categoria1);

        productoService.findAll().forEach(System.out::println);
    }
}
