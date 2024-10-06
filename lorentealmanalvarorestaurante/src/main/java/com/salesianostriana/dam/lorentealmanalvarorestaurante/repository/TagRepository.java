package com.salesianostriana.dam.lorentealmanalvarorestaurante.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.lorentealmanalvarorestaurante.model.Tag;
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByNombre(String nombre);
}

