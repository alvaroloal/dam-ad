package com.salesianostriana.dam.ejercicio01_modeladodatos.repo;

import com.salesianostriana.dam.ejercicio01_modeladodatos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
