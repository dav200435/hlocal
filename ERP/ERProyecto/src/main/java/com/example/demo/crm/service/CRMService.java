package com.example.demo.crm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.crm.model.Cliente;
import com.example.demo.crm.repository.CRMRepository;

import java.util.List;
import java.util.Optional;
 
@Service
public class CRMService {
 
	@Autowired
	private CRMRepository crmRepository;
	
	public List<Cliente> obtenerClientes(){
		return crmRepository.findAll();
	}
	
	public Optional<Cliente> obtenerPorId(Long id){
		return crmRepository.findById(id);
	}
	
	public void eliminarClientes(Long id) {
		crmRepository.deleteById(id);
	}
	
	public Cliente guardarCliente(Cliente cliente) {
		return crmRepository.save(cliente);
	}
	
	public Cliente actualizarClientes(Long id, Cliente clienteActualizada) {
        return crmRepository.findById(id).map(cliente -> {
            cliente.setNombre(clienteActualizada.getNombre());
            cliente.setEmail(clienteActualizada.getEmail());
            cliente.setTelefono(clienteActualizada.getTelefono());
            cliente.setVentas(clienteActualizada.getVentas());
            return crmRepository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

	}
	
	public Page<Cliente> listarClientesPaginados(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size, Sort.by("fecha").descending());
	    return crmRepository.findAll(pageable);
	}
}
