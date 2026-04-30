package com.example.customer_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion;

    // getters y setters

    public Long getId() {
        return id;
    }   

    public void setId(Long id) {
        this.id = id;
    }   

    public Usuario getUsuario() {
        return usuario;
    }   

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   

    public Libro getLibro() {
        return libro;
    }   

    public void setLibro(Libro libro) {
        this.libro = libro;
    }   

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }   

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }   

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }   

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}