package com.example.customer_api.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

import com.example.customer_api.model.*;
import com.example.customer_api.repository.*;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepo;
    private final UsuarioRepository usuarioRepo;
    private final LibroRepository libroRepo;

    public PrestamoService(PrestamoRepository prestamoRepo,
                           UsuarioRepository usuarioRepo,
                           LibroRepository libroRepo) {
        this.prestamoRepo = prestamoRepo;
        this.usuarioRepo = usuarioRepo;
        this.libroRepo = libroRepo;
    }

    // PRESTAR LIBRO
    public Prestamo prestar(Long usuarioId, Long libroId) {

        Usuario usuario = usuarioRepo.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        Libro libro = libroRepo.findById(libroId)
            .orElseThrow(() -> new RuntimeException("Libro no existe"));

        // validar si ya está prestado
        prestamoRepo.findByLibro_IdAndFechaDevolucionIsNull(libroId)
            .ifPresent(p -> {
                throw new RuntimeException("Libro ya está prestado");
            });

        Prestamo prestamo = new Prestamo();
        prestamo.setUsuario(usuario);
        prestamo.setLibro(libro);
        prestamo.setFechaPrestamo(LocalDate.now());

        return prestamoRepo.save(prestamo);
    }

    //  DEVOLVER LIBRO
    public Prestamo devolverPorId(Long prestamoId) {

        Prestamo prestamo = prestamoRepo.findById(prestamoId)
            .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        if (prestamo.getFechaDevolucion() != null) {
            throw new RuntimeException("Este préstamo ya fue devuelto");
        }

        prestamo.setFechaDevolucion(java.time.LocalDate.now());

        return prestamoRepo.save(prestamo);
    }

    public List<Prestamo> getAll() {
        return prestamoRepo.findAll();
    }

    public Prestamo getById(Long id) {
        return prestamoRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
    }
}