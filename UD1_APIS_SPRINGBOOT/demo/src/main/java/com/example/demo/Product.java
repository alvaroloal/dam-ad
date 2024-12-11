package com.example.demo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data// genera los getter y setter para cada atributo getId() setId()
@AllArgsConstructor// constructor con todos los argumentos
@NoArgsConstructor// constructor vacío
@Builder
public class Product {
    private Long id;
    private String name;
    private double price;

}
