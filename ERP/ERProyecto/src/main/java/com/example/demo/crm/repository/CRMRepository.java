package com.example.demo.crm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.crm.model.Cliente;

@Repository
public interface CRMRepository extends JpaRepository<Cliente, Long> {
	
	Page<Cliente> findAll(Pageable pageable);
 
}

