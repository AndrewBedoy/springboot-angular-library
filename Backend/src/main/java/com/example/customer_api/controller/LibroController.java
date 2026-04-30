package com.example.customer_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.customer_api.model.Libro;
import com.example.customer_api.service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libro> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Libro getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Libro create(@RequestBody Libro libro) {
        return service.create(libro);
    }

    
    @PutMapping("/{id}")
    public Libro update(@PathVariable Long id, @RequestBody Libro l) {
        return service.update(id, l);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}