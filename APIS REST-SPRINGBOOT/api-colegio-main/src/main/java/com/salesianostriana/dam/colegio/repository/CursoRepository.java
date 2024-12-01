package com.salesianostriana.dam.colegio.repository;

import com.salesianostriana.dam.colegio.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
