package com.openwebinars.rest.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Producto {

	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;

	public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
	
}
