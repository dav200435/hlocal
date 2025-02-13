package com.example.demo.crm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import com.example.demo.ventas.model.Venta;

@Entity
@Table(name="/cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    @NotNull(message = "introduce nombre")
    private String nombre;
    @Column(name="email")
    @NotNull(message = "introduce email")
    private String email;
    @Column(name="telefono")
    @NotNull(message = "introduce telefono")
    private String telefono;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venta> ventas;
    
    public Cliente() {}
    
    public Cliente(Long id, String nombre, String email, String telefono, List<Venta> ventas) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.ventas = ventas;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

    
}

