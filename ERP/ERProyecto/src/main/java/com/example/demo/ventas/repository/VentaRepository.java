package com.example.demo.ventas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ventas.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
	
	Page<Venta> findAll(Pageable pageable);
 
}
