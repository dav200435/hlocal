package com.example.demo.producto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import com.example.demo.ventas.model.Venta;

@Entity
@Table(name="/producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    @NotNull(message = "introduce nombre")
    private String nombre;
    @Column(name="precio")
    @NotNull(message = "introduce precio unitario")
    private Double precio;

    @Column(name="stock")
    @NotNull(message = "introduce telefono")
    private Integer stock;
    
    public Producto() {}

	public Producto(Long id, @NotNull(message = "introduce nombre") String nombre,
			@NotNull(message = "introduce precio unitario") Double precio,
			@NotNull(message = "introduce telefono") Integer stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}



	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	

    
}


