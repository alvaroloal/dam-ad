package com.salesianostriana.dam.ejercicio01_modeladodatos.service;

import com.salesianostriana.dam.ejercicio01_modeladodatos.model.Categoria;
import com.salesianostriana.dam.ejercicio01_modeladodatos.repo.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {

        List<Categoria> result = categoriaRepository.findAll();

        if (result.isEmpty())
            throw new EntityNotFoundException();

        return result;
    }

    public Categoria save(Categoria categoria) {

        return categoriaRepository.save(categoria);
    }
}
