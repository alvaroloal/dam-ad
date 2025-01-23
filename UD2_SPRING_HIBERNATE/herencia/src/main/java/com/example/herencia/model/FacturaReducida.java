package com.example.herencia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="Reducida")
@Getter
@Setter
public class FacturaReducida extends Factura{


    public FacturaReducida(String numero, String concepto, double importe) {
        super(numero, concepto, importe);
    }

    @Override
    public double importeConIva() {
        return this.getImporte()*1.05;
    }

}
