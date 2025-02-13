package com.example.demo.producto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.producto.model.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	Page<Producto> findAll(Pageable pageable);
 
}
