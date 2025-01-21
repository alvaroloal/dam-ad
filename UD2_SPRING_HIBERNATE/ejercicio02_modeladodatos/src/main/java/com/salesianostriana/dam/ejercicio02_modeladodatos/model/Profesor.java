package com.salesianostriana.dam.ejercicio02_modeladodatos.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, email;

    private double puntuacion;

    @Builder.Default
    @Setter(AccessLevel.NONE)
    @OneToMany(
            mappedBy = "profesor",
            fetch = FetchType.EAGER
    )
    List<CursoOnline> cursos = new ArrayList<>();

    public void addCurso(CursoOnline cursoOnline) {

        cursoOnline.setProfesor(this);
        this.cursos.add(cursoOnline);
    }

    public void removeCurso(CursoOnline cursoOnline) {

        this.cursos.remove(cursoOnline);
        cursoOnline.setProfesor(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Profesor profesor = (Profesor) o;
        return getId() != null && Objects.equals(getId(), profesor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
