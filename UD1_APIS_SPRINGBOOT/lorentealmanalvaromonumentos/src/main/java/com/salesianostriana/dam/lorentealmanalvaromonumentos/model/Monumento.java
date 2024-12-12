package com.salesianostriana.dam.lorentealmanalvaromonumentos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Monumento {

    private Long id;
    private String codPais;
    private String nombrePais;
    private String nombreCiudad;
    private double latitud;
    private double longitud;
    private String nombreMonumento;
    private String descripcion;
    private String fotoUrl;

}
