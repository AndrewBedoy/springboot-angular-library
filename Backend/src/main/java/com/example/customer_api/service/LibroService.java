package com.example.customer_api.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.customer_api.model.Autor;
import com.example.customer_api.model.Libro;
import com.example.customer_api.repository.AutorRepository;
import com.example.customer_api.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository repo;
    private final AutorRepository autorRepo;

    public LibroService(LibroRepository repo, AutorRepository autorRepo) {
        this.repo = repo;
        this.autorRepo = autorRepo;
    }

    public List<Libro> getAll() {
        return repo.findAll();
    }

    public Libro getById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

   public Libro create(Libro libro) {

    Autor autorRequest = libro.getAutor();

    Autor autor = autorRepo.findByNombre(autorRequest.getNombre())
        .map(existing -> {
            // actualizar si vienen nuevos datos
            if (autorRequest.getNacionalidad() != null) {
                existing.setNacionalidad(autorRequest.getNacionalidad());
            }
            if (autorRequest.getFechaNacimiento() != null) {
                existing.setFechaNacimiento(autorRequest.getFechaNacimiento());
            }
            return autorRepo.save(existing);
        })
        .orElseGet(() -> {
            Autor nuevo = new Autor();
            nuevo.setNombre(autorRequest.getNombre());
            nuevo.setNacionalidad(autorRequest.getNacionalidad());
            nuevo.setFechaNacimiento(autorRequest.getFechaNacimiento());
            return autorRepo.save(nuevo);
        });

    libro.setAutor(autor);

    return repo.save(libro);
}

    public Libro update(Long id, Libro updated) {
        Libro libro = getById(id);

        libro.setTitulo(updated.getTitulo());
        libro.setGenero(updated.getGenero());
        libro.setAnioPublicacion(updated.getAnioPublicacion());

        // VALIDAR AUTOR
        if (updated.getAutor() != null) {
            Long autorId = updated.getAutor().getId();

            Autor autor = autorRepo.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

            libro.setAutor(autor);
        }

        return repo.save(libro);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}