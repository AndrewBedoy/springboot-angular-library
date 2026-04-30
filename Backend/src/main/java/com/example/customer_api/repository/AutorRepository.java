package com.example.customer_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.customer_api.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);
}