package com.example.customer_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer_api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}