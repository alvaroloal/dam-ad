package com.salesianostriana.dam.data;

import com.salesianostriana.dam.data.repo.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataBaseViewer {

    private final ProductoRepository repository;

    @PostConstruct
    public void init() {

        repository.findAll().forEach(System.out::println);

    }

 }
