package com.salesianostriana.dam.data.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "bibliotecas")
public class Biblioteca {

    @Id
    @GeneratedValue
    private Long id;

    private String direccion;


    @OneToMany(
            mappedBy = "biblioteca",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    @ToString.Exclude
    private List<Libro> libros = new ArrayList<>();

    //metodos helper
    public void addLibro(Libro l) {
        l.setBiblioteca(this);
        this.getLibros().add(l);
    }

    public void removeLibro(Libro l) {
        this.getLibros().remove(l);
        l.setBiblioteca(null);
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Biblioteca biblioteca = (Biblioteca) o;
        return getId() != null && Objects.equals(getId(), biblioteca.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
