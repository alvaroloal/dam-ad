package com.salesianos.triana.dam.ejercicio03.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Estacion {

    @Id
    @GeneratedValue
    private Long id;

    private double numero;
    private String nombre;
    private String coordenadas;
    private int capacidad;

    @OneToMany(mappedBy = "estacion")
    @ToString.Exclude
    private List<Bicicleta> bicicletas;

    @OneToMany(mappedBy = "estacionFinal")
    @ToString.Exclude
    private List<Uso> usosFinalizados;

    // helpers bicicleta
    public void addBicicleta(Bicicleta b) {
        this.bicicletas.add(b);
        b.setEstacion(this);
    }

    public void removeBicicleta(Bicicleta b) {
        this.bicicletas.remove(b);
        b.setEstacion(null);
    }

    // helpers uso
    public void addUso(Uso u) {
        this.usosFinalizados.add(u);
        u.setEstacionFinal(this);
    }

    public void removeUso(Uso u) {
        this.usosFinalizados.remove(u);
        u.setEstacionFinal(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Estacion estacion = (Estacion) o;
        return getId() != null && Objects.equals(getId(), estacion.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
