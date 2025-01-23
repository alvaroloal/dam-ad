package com.example.herencia.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;



@Getter
@Entity
public class Experto {
    @Id
    private String nombre;

    public Experto() {
        super();
    }
    @OneToMany(mappedBy = "experto", cascade = CascadeType.PERSIST)
    private List < Graduado > graduados = new ArrayList < Graduado>() > ();

    public void setImparticiones(List < Graduado > graduados) {
        this.graduados = graduados;
    }

    public Experto(String nombre) {
        super();
        this.nombre = nombre;
    }


    public void addGraduado(Graduado g) {

        graduados.add(g);
    }

}
