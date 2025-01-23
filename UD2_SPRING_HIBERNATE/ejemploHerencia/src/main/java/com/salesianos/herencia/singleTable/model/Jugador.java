package com.salesianos.herencia.singleTable.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Jugador {

    @Id
    @GeneratedValue
    protected Long id;

    protected String nombre;
    protected int edad;
    protected double salario;
    protected int partidosJugados;
    protected int dorsal;

}
