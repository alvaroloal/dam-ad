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
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double puntuacion;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "profesor_id",
    foreignKey = @ForeignKey(name = "fk_curso_online_profesor"))
    private Profesor profesor;

    @Builder.Default
    @Setter(AccessLevel.NONE)
    @OneToMany(
            mappedBy = "cursoOnline",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Video> videos = new ArrayList<>();

    public void addVideo(Video video) {

        video.setCursoOnline(this);
        this.videos.add(video);
    }

    public void removeVideo(Video video) {

        this.videos.remove(video);

    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CursoOnline that = (CursoOnline) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
