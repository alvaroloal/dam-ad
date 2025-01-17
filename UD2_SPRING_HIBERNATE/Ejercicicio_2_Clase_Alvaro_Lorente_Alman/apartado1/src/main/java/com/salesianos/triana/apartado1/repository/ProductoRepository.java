package com.salesianos.triana.apartado1.repository;

import com.salesianos.triana.apartado1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Long> {
}
