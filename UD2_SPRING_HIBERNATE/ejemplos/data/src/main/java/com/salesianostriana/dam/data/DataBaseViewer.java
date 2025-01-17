package com.salesianostriana.dam.data;

import com.salesianostriana.dam.data.model.Producto;
import com.salesianostriana.dam.data.repo.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

<<<<<<<< HEAD:UD2_SPRING_HIBERNATE/ejemplos/data/src/main/java/com/salesianostriana/dam/data/PseudoMain.java
import java.util.List;

@Component
@RequiredArgsConstructor
public class PseudoMain {
========
@Component
@RequiredArgsConstructor
public class DataBaseViewer {
>>>>>>>> f01bcd5b429a8f7d9bfd55817d27647b88d69c03:UD2_SPRING_HIBERNATE/ejemplos/data/src/main/java/com/salesianostriana/dam/data/DataBaseViewer.java

    private final ProductoRepository repository;

    @PostConstruct
    public void init() {

        repository.findAll().forEach(System.out::println);

    }

 }
