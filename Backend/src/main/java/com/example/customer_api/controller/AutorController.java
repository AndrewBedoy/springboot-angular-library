package com.example.customer_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.customer_api.model.Autor;
import com.example.customer_api.service.AutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    // GET todos
    @GetMapping
    public List<Autor> getAll() {
        return service.getAll();
    }

    // GET por ID
    @GetMapping("/{id}")
    public Autor getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // POST crear
    @PostMapping
    public Autor create(@RequestBody Autor autor) {
        return service.create(autor);
    }

    // PUT actualizar
    @PutMapping("/{id}")
    public Autor update(@PathVariable Long id, @RequestBody Autor autor) {
        return service.update(id, autor);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}