package com.salesianos.herencia.singleTable.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@DiscriminatorValue("D")
@NoArgsConstructor
public class Delantero extends Jugador{

    private int goles;

    public Delantero(Long id, String nombre, int edad, double salario, int partidosJugados, int dorsal, int goles) {
        super(id, nombre, edad, salario, partidosJugados, dorsal);

    }
}
