package com.salesianostriana.dam.colegio.repository;

import com.salesianostriana.dam.colegio.model.MatriculaNotas;
import com.salesianostriana.dam.colegio.model.MatriculaNotasPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaNotasRepository extends JpaRepository<MatriculaNotas, MatriculaNotasPK> {
}
