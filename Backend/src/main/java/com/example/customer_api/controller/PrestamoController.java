package com.example.customer_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.customer_api.model.Prestamo;
import com.example.customer_api.service.PrestamoService;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService service;

    public PrestamoController(PrestamoService service) {
        this.service = service;
    }

   @GetMapping
    public List<Prestamo> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Prestamo getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // prestar libro
    @PostMapping("/prestar")
    public Prestamo prestar(@RequestParam Long usuarioId,
                            @RequestParam Long libroId) {
        return service.prestar(usuarioId, libroId);
    }

    @PostMapping("/devolver/{id}")
    public Prestamo devolver(@PathVariable Long id) {
        return service.devolverPorId(id);
    }
}