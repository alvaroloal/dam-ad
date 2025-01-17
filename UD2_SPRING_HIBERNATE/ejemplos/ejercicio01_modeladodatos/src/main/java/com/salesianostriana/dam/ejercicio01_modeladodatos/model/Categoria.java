package com.salesianostriana.dam.ejercicio01_modeladodatos.model;

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
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @Builder.Default
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @OneToMany(
            mappedBy = "categoria",
            fetch = FetchType.EAGER
    )
    private List<Producto> productos = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER)
    private List<Categoria> categoriasHijas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoria_padre")
    private Categoria categoriaPadre;

    public void addHija(Categoria categoria) {

        categoria.setCategoriaPadre(this);
        categoriasHijas.add(categoria);
    }

    public void removeHija(Categoria categoria) {

        categoriasHijas.remove(categoria);
        categoria.setCategoriaPadre(null);
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Categoria categoria = (Categoria) o;
        return getId() != null && Objects.equals(getId(), categoria.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }




}
