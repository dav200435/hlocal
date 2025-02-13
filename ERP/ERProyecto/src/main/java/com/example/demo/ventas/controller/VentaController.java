package com.example.demo.ventas.controller;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ventas.model.Venta;
import com.example.demo.ventas.service.VentaService;

import jakarta.validation.Valid;
 
@RestController
@RequestMapping("/ERP/ventas")
public class VentaController {
	
	@Autowired
    private VentaService ventaService;
 
    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.obtenerVentas();
    }
 
    @GetMapping("/{id}")
    public Optional<Venta> obtenerVenta(@PathVariable Long id) {
        return ventaService.obtenerPorId(id);
    }
 
    @PostMapping
    public Venta crearVenta(@Valid @RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }
 
    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Long id) {
    	ventaService.eliminarVenta(id);
    }
    
    @PutMapping("/{id}")
    public Venta actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
    	return ventaService.actualizarVenta(id, venta);
    }
    
    @GetMapping("/paginado")
    public Page<Venta> listarVentasPaginadas(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "5") int size) {
        return ventaService.listarVentasPaginadas(page, size);
    }
}