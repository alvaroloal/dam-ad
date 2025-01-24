package com.salesianos.herencia.mappedSuperClass.repos;

import com.salesianos.herencia.mappedSuperClass.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
