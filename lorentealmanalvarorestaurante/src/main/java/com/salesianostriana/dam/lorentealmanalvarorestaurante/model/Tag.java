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
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String contenido;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "tag_restaurante",joinColumns = @JoinColumn(name="tag_id"), inverseJoinColumns = @JoinColumn(name="restaurante_id") )
    @JsonIgnoreProperties("tags")
    private List <Restaurante> restaurantes;
    
}
