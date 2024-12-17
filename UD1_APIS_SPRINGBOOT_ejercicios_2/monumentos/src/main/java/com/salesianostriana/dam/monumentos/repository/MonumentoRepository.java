package com.salesianostriana.dam.monumentos.repository;

import com.salesianostriana.dam.monumentos.model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonumentoRepository extends JpaRepository<Monumento, Long> {

    @Query("""
            SELECT m
            FROM Monumento m
            ORDER BY m.nombreMonumento ASC
            """)
    List<Monumento> findAllAsc();

    @Query("""
            SELECT m
            FROM Monumento m
            ORDER BY m.nombreMonumento DESC
            """)
    List<Monumento> findAllDesc();
}
