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
                .nombre("Smartphone")
                .pvp(599.99)
                .build();
        Categoria categoria1 = Categoria.builder()
                .nombre("Dispositivos móviles")
                .build();

        producto1.addToCategoria(categoria1);

        categoriaService.save(categoria1);
        productoService.save(producto1);

        Categoria categoriaPadre = Categoria.builder()
                .nombre("Tecnología de consumo")
                .build();
        categoriaPadre.addHija(categoria1);
        categoriaService.save(categoriaPadre);
        categoriaService.save(categoria1);

        productoService.findAll().forEach(System.out::println);
    }
}
