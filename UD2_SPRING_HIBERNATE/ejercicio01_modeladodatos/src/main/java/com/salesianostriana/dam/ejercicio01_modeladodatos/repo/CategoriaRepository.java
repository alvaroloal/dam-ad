package com.salesianostriana.dam.ejercicio01_modeladodatos.repo;

import com.salesianostriana.dam.ejercicio01_modeladodatos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
