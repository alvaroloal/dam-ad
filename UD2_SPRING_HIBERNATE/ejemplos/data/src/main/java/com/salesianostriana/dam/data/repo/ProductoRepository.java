package com.salesianostriana.dam.data.repo;

import com.salesianostriana.dam.data.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
