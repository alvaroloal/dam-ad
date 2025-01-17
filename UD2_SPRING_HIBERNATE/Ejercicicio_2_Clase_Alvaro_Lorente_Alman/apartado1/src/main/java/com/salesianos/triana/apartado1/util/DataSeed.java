package com.salesianos.triana.apartado1.util;



import com.salesianos.triana.apartado1.model.Categoria;
import com.salesianos.triana.apartado1.model.Producto;
import com.salesianos.triana.apartado1.repository.CategoriaRepository;
import com.salesianos.triana.apartado1.repository.ProductoRepository;
import org.springframework.stereotype.Component;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


import java.util.Arrays;

@Component
public class DataSeed implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");


        Producto producto1 = new Producto();
        producto1.setNombre("iPhone 14");
        producto1.setPvp(999.99);


        Producto producto2 = new Producto();
        producto2.setNombre("Samsung Galaxy S23");
        producto2.setPvp(899.99);


        productoRepository.saveAll(Arrays.asList(producto1, producto2));


    }
}



