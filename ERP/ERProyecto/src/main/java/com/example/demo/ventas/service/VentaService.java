package com.example.demo.ventas.service;

import com.example.demo.ventas.model.Venta;
import com.example.demo.ventas.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class VentaService {
 
	@Autowired
	private VentaRepository ventaRepository;
	
	public List<Venta> obtenerVentas(){
		return ventaRepository.findAll();
	}
	
	public Optional<Venta> obtenerPorId(Long id){
		return ventaRepository.findById(id);
	}
	
	public void eliminarVenta(Long id) {
		ventaRepository.deleteById(id);
	}
	
	public Venta guardarVenta(Venta venta) {
		if (venta.getCliente() == null || venta.getCliente().getId() == null)
			throw new IllegalArgumentException("cliente nulo");
		return ventaRepository.save(venta);
	}

	public Venta actualizarVenta(Long id, Venta ventaActualizada) {
        return ventaRepository.findById(id).map(venta -> {
            venta.setCliente(ventaActualizada.getCliente());
            venta.setFecha(ventaActualizada.getFecha());
            venta.setTotal(ventaActualizada.getTotal());
            return ventaRepository.save(venta);
        }).orElseThrow(() -> new RuntimeException("Venta no encontrada"));

	}
	
	public Page<Venta> listarVentasPaginadas(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size, Sort.by("fecha").descending());
	    return ventaRepository.findAll(pageable);
	}
}
