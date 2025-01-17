package com.salesianos.dam.composicionId.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@IdClass(LineaPedido.class)
public class LineaPedido {

    @Id @GeneratedValue
    private Long id;

    @Id
    @ManyToOne
    private Pedido pedido;



}
