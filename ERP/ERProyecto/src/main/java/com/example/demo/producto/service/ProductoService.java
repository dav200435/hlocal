package com.example.demo.producto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.producto.model.Producto;
import com.example.demo.producto.repository.ProductoRepository;


@Service
public class ProductoService {
 
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> obtenerProductos(){
		return productoRepository.findAll();
	}
	
	public Optional<Producto> obtenerPorId(Long id){
		return productoRepository.findById(id);
	}
	
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}
	
	public Producto guardarProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public Producto actualizarProducto(Long id, Producto productoActualizada) {
        return productoRepository.findById(id).map(producto -> {
        	producto.setNombre(productoActualizada.getNombre());
        	producto.setPrecio(productoActualizada.getPrecio());
        	producto.setStock(productoActualizada.getStock());
            return productoRepository.save(producto);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

	}
	
	public Page<Producto> listarProductosPaginados(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size, Sort.by("fecha").descending());
	    return productoRepository.findAll(pageable);
	}
}
