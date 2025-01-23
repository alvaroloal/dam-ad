package com.example.herencia.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

;

@Entity
@Getter
@Setter
public class Graduado {
    @Id
    private int id;
    private Date fecha;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "nombreExperto")
    private Experto experto;

    public Graduado(int id, Date fecha, String titulo, Experto experto) {
        super();
        this.fecha = fecha;
        this.titulo = titulo;
        this.experto = experto;
    }


}
