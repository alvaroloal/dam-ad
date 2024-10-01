package com.salesianostriana.dam.lorentealmanalvaromonumentos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.lorentealmanalvaromonumentos.model.Monumento;

public interface MonumentoRepository extends JpaRepository<Monumento, Long> {
}

