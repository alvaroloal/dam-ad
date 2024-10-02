package com.salesianostriana.dam.lorentealmanalvarorestaurante.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private double latitud;

    @Column(nullable = false)
    private double longitud;

    @Column(nullable = false, length=500)
    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "restaurante_tag",joinColumns = @JoinColumn(name="restaurante_id"), inverseJoinColumns = @JoinColumn(name="tag_id") )
    @JsonIgnoreProperties("restaurantes")
    private List <Tag> tags;

    @Column(nullable = false)
    private String fotoUrl;

    
    
}
