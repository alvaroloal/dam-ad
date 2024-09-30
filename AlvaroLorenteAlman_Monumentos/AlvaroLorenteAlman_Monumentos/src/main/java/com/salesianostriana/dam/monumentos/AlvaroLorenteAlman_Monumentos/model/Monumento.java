package com.salesianostriana.dam.monumentos.AlvaroLorenteAlman_Monumentos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue
    private long id;

    private String codPais;
    private String nombrePais;
    private String coordenadas;
    private String nombre;
    private String descripción;
    private String foto;
}



