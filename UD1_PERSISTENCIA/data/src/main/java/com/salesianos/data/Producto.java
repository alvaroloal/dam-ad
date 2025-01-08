package com.salesianos.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity//cuando anoto una clase con Entity tengo que generar un id
@ToString
@Table(name = "productos")
public class Producto {

    @Id @GeneratedValue//no se pueden repetir, debe ser un valor inmutable que no cambia nunca //estrategia de generacion del id: AUTO, INDENTITY, SEQUENCE, TABLE
    private Long id;

    private String nombre;
    private double precio;

}
