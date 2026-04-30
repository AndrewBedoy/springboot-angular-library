package com.example.customer_api.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.customer_api.model.Autor;
import com.example.customer_api.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository repo;

    public AutorService(AutorRepository repo) {
        this.repo = repo;
    }

    // Obtener todos
    public List<Autor> getAll() {
        return repo.findAll();
    }

    // Obtener por ID
    public Autor getById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    // Crear autor
    public Autor create(Autor autor) {
        return repo.save(autor);
    }

    // Actualizar autor
    public Autor update(Long id, Autor updated) {
        Autor autor = getById(id);

        autor.setNombre(updated.getNombre());
        autor.setNacionalidad(updated.getNacionalidad());
        autor.setFechaNacimiento(updated.getFechaNacimiento());

        return repo.save(autor);
    }

    // Eliminar
    public void delete(Long id) {
        repo.deleteById(id);
    }
}