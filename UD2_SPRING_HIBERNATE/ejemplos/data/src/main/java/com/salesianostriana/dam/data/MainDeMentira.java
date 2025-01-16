package com.salesianostriana.dam.data;

import com.salesianostriana.dam.data.model.Producto;
import com.salesianostriana.dam.data.repo.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira{

    private final ProductoRepository repository;

    @PostConstruct
    public void init() {

        repository.findAll().forEach(System.out::println);

    }

 }
