package com.salesianostriana.dam.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos personalizados (si es necesario)
    List<Usuario> findByNombre(String nombre);
}
