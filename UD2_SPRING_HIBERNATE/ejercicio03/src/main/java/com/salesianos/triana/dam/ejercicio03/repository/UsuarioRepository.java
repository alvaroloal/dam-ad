package com.salesianos.triana.dam.ejercicio03.repository;

import com.salesianos.triana.dam.ejercicio03.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
