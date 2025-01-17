package com.salesianos.triana.apartado2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer orden;
    private String titulo;
    private String descripcion;
    private String url;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoOnline curso;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id) && Objects.equals(orden, video.orden) && Objects.equals(titulo, video.titulo) && Objects.equals(descripcion, video.descripcion) && Objects.equals(url, video.url) && Objects.equals(curso, video.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orden, titulo, descripcion, url, curso);
    }
}

