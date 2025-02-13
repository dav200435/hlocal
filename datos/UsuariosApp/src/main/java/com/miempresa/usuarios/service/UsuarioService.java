package com.miempresa.usuarios.service;

import com.miempresa.usuarios.model.Usuario;
import com.miempresa.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorio;

    public List<Usuario> obtenerTodos() {
        return repositorio.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        repositorio.deleteById(id);
    }
}
