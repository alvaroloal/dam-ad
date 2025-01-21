package com.salesianostriana.dam.ejercicio01_modeladodatos.service;

import com.salesianostriana.dam.ejercicio01_modeladodatos.model.Producto;
import com.salesianostriana.dam.ejercicio01_modeladodatos.repo.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> findAll() {

        List<Producto> result = productoRepository.findAll();

        if(result.isEmpty())
            throw new EntityNotFoundException();

        return result;
    }

    public Producto save(Producto producto) {

        return productoRepository.save(producto);
    }
}
