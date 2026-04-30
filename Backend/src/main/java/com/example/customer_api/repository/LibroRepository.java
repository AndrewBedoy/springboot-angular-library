package com.example.customer_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer_api.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
