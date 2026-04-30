package com.example.customer_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Integer anioPublicacion;   
    private String genero;

    @ManyToOne
    @JoinColumn(name = "autor_id")  
    private Autor autor;

    // getters y setters
    public Long getId() { return id; }      
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }  

    public Integer getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(Integer anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }  

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }   
    
}