package com.salesianos.triana.apartado1.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Producto {


    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double pvp;


    @ManyToOne
    @JoinColumn(name = "categoria_id",
            foreignKey = @ForeignKey(name = "fk_producto_categoria"))
    private Categoria categoria;


}
