package com.salesianos.data.service;

import com.salesianos.data.dto.EditCategoriaCmd;
import com.salesianos.data.model.Categoria;
import com.salesianos.data.repos.CategoriaRepository;
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
            throw new EntityNotFoundException("No hay categorias con esos criterios de búsqueda");
        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: "+ id));

    }

    /*public Categoria save (Categoria categoria) {
        return categoriaRepository.save(categoria);
    }*/

    public Categoria save(EditCategoriaCmd nuevo) {
        return categoriaRepository.save(Categoria.builder()
                        .nombre(nuevo.nombre())
                    
                    
                .build());
    }

    /*public Categoria edit(Categoria categoria, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.getNombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: "+ id));

    }*/
    public Categoria edit(EditCategoriaCmd editCategoriaCmd, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(editCategoriaCmd.nombre());
                    //old.setCategoria(categoriaRepository.getReferenceById(editCategoriaCmd.productoId()));
                    //old.setProductos(categoriaRepository.findById(editCategoriaCmd.productoId()).orElse(null));
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));

    }


    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    public void deleteById(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoria no encontrada");
        }
        categoriaRepository.deleteById(id);
    }

    

}
