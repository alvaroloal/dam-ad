package com.example.herencia.model;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value="SinIva")
public class FacturaSinIva extends Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FacturaSinIva(String numero, String concepto, double importe) {
        super(numero, concepto, importe);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double importeConIva() {
        // TODO Auto-generated method stub
        return this.getImporte();
    }

}
