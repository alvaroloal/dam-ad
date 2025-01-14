package com.salesianostriana.dam.data.service;

import com.salesianostriana.dam.data.model.Categoria;
import com.salesianostriana.dam.data.model.Producto;
import com.salesianostriana.dam.data.repo.CategoriaRepository;
import com.salesianostriana.dam.data.repo.ProductoRepository;
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

        if(result.isEmpty())
            throw new EntityNotFoundException();

        return result;
    }

    public Categoria findById(Long id) {

        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado una categoría con el ID: %d".formatted(id)));
    }

    public Categoria save(Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

    public Categoria edit(Categoria categoria, Long id) {

        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.getNombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado ninguna categoría con el ID: %d".formatted(id)));
    }

    public void delete(Long id) {

        categoriaRepository.deleteById(id);
    }
}
