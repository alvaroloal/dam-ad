package com.salesianostriana.dam.monumentos.AlvaroLorenteAlman_Monumentos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//cuando se crea un monumento el id se genera automatiamente
    private Long id;
    
    @Column(nullable = false, length = 2)//EL CODIGO TIENE DOS CARACTERES POR ESO SE FUERZA A QUE SEA 2
    private String codPais;

    @Column(nullable = false)
    private String nombrePais;

    @Column(nullable = false)
    private String nombreCiudad;

    @Column(nullable = false)
    private double latitud;

    @Column(nullable = false)
    private double longitud;

    @Column(nullable = false)
    private String nombreMonumento;

    @Column(nullable = false, length=500)
    private String descripcion;

    @Column(nullable = false)
    private String fotoUrl;
}
