package com.salesianostriana.dam.data.repo;

import com.salesianostriana.dam.data.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository <Biblioteca, Long> {
}
