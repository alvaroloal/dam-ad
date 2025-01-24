package com.salesianos.herencia.mappedSuperClassv2.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Empleado extends Persona{

    private String puesto;

    private double sueldo;
}
