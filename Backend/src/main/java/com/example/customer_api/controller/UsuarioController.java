package com.example.customer_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.customer_api.model.Usuario;
import com.example.customer_api.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario u) {
        return service.create(u);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario u) {
        return service.update(id, u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}