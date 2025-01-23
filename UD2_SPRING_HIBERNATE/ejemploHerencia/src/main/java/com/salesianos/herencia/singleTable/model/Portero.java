package com.salesianos.herencia.singleTable.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("P")
@NoArgsConstructor
public class Portero extends Jugador{

    private int golesEncajados;

    public Portero(Long id, String nombre, int edad, double salario, int partidosJugados, int dorsal, int goles) {
        super(id, nombre, edad, salario, partidosJugados, dorsal);

    }
}