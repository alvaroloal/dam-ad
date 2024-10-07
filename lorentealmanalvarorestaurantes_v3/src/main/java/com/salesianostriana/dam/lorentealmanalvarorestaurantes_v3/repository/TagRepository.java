package com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.model.Tag;
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}

