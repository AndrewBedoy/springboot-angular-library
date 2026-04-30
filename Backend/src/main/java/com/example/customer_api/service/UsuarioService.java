package com.example.customer_api.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.customer_api.model.Usuario;
import com.example.customer_api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> getAll() {
        return repo.findAll();
    }

    public Usuario getById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario create(Usuario u) {
        return repo.save(u);
    }

    public Usuario update(Long id, Usuario updated) {
        Usuario usuario = getById(id);

        usuario.setNombre(updated.getNombre());
        usuario.setEmail(updated.getEmail());
        usuario.setTelefono(updated.getTelefono());

        return repo.save(usuario);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}