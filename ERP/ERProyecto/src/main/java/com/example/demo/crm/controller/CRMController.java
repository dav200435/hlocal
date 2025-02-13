package com.example.demo.crm.controller;

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

import com.example.demo.crm.model.Cliente;
import com.example.demo.crm.service.CRMService;
 
@RestController
@RequestMapping("/ERP/CRM")
public class CRMController {
	
	@Autowired
    private CRMService crmService;
 
    @GetMapping
    public List<Cliente> listarClientes() {
        return crmService.obtenerClientes();
    }
 
    @GetMapping("/{id}")
    public Optional<Cliente> obtenerCliente(@PathVariable Long id) {
        return crmService.obtenerPorId(id);
    }
 
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return crmService.guardarCliente(cliente);
    }
 
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
    	crmService.eliminarClientes(id);
    }
    
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
    	return crmService.actualizarClientes(id, cliente);
    }
    
    @GetMapping("/paginado")
    public Page<Cliente> listarClientePaginados(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "5") int size) {
        return crmService.listarClientesPaginados(page, size);
    }
}
