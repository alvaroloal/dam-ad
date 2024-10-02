package com.salesianostriana.dam.lorentealmanalvarorestaurante.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "restaurante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private Double latitud;

    @Column(nullable = false)
    private Double longitud;

    @Column(length = 1000)
    private String descripcion;

    private String fotoUrl;

    @ManyToMany(mappedBy = "restaurantes",fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    // @JoinTable(name = "restaurante_tags",
    //     joinColumns = { @JoinColumn(name = "restaurante_id") },
    //     inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    @JsonIgnoreProperties("restaurantes")
    private List<Tag> tags;

    

    // Métodos para manejar la relacion con tag // metodos helper
    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.getRestaurantes().add(this);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
        tag.getRestaurantes().remove(this);
    }


}






