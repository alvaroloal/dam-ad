package com.salesianos.herencia.mappedSuperClassv2.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Persona {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private int edad;
}
