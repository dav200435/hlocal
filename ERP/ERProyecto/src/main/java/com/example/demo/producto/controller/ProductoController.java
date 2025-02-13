package com.example.demo.producto.controller;

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

import com.example.demo.producto.model.Producto;
import com.example.demo.producto.service.ProductoService;

 
@RestController
@RequestMapping("/ERP/producto")
public class ProductoController {
	
	@Autowired
    private ProductoService crmService;
 
    @GetMapping
    public List<Producto> listarClientes() {
        return crmService.obtenerProductos();
    }
 
    @GetMapping("/{id}")
    public Optional<Producto> obtenerCliente(@PathVariable Long id) {
        return crmService.obtenerPorId(id);
    }
 
    @PostMapping
    public Producto crearCliente(@RequestBody Producto producto) {
        return crmService.guardarProducto(producto);
    }
 
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
    	crmService.eliminarProducto(id);
    }
    
    @PutMapping("/{id}")
    public Producto actualizarCliente(@PathVariable Long id, @RequestBody Producto producto) {
    	return crmService.actualizarProducto(id, producto);
    }
    
    @GetMapping("/paginado")
    public Page<Producto> listarClientePaginados(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "5") int size) {
        return crmService.listarProductosPaginados(page, size);
    }
}

