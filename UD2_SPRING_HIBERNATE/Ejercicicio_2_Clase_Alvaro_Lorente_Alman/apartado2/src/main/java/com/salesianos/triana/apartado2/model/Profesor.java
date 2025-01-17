package com.salesianos.triana.apartado2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private Double puntuacion;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CursoOnline> cursos;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(id, profesor.id) && Objects.equals(nombre, profesor.nombre) && Objects.equals(email, profesor.email) && Objects.equals(puntuacion, profesor.puntuacion) && Objects.equals(cursos, profesor.cursos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, puntuacion, cursos);
    }
}

