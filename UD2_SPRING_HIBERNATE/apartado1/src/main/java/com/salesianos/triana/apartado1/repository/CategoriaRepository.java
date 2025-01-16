package com.salesianos.triana.apartado1.repository;

import com.salesianos.triana.apartado1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategotiaRepository extends JpaRepository <Categoria, Long> {
}
