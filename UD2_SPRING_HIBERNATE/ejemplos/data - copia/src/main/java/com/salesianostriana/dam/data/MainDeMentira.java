package com.salesianostriana.dam.data;

import com.salesianostriana.dam.data.repo.LibroRepository;
import com.salesianostriana.dam.data.repo.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository repository;
    private final LibroRepository libroRepository;

    @PostConstruct
    public void init() {

        repository.findAll().forEach(System.out::println);

        libroRepository.findAll().forEach(System.out::println);



    }

 }
