package com.salesianostriana.dam.ejercicio02_modeladodatos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoId {

    private Long id;
    private CursoOnline cursoOnline;
}
