package com.example.customer_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer_api.model.Prestamo;

import java.util.Optional;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    Optional<Prestamo> findByLibro_IdAndFechaDevolucionIsNull(Long libroId);
}