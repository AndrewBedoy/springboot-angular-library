import { Component, OnInit } from '@angular/core';
import { LibroService } from '../../services/libro.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-libros',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './libros.component.html',
  styleUrl: './libros.component.css'
})
export class LibrosComponent implements OnInit {

  libros: any[] = [];

  nuevoLibro: any = {
    titulo: '',
    genero: '',
    anioPublicacion: ''
  };

  nuevoAutor: any = {
    nombre: '',
    nacionalidad: '',
    fechaNacimiento: ''
  };

  editando: any = null;

  searchLibros: string = '';
  librosFiltrados: any[] = [];

  constructor(private libroService: LibroService) {}

  ngOnInit() {
    this.loadLibros();
  }

  loadLibros() {
    this.libroService.getAll().subscribe(data => {
      this.libros = data;
       this.librosFiltrados = data;
    });
  }
   errorMsg: string = '';
  create() {
    this.errorMsg = '';
    if (!this.nuevoAutor.nombre || this.nuevoAutor.nombre.trim() === '' || !this.nuevoAutor.nacionalidad || this.nuevoAutor.nacionalidad.trim() === '' || !this.nuevoAutor.fechaNacimiento || this.nuevoAutor.fechaNacimiento.trim() === '' ) {
      this.errorMsg = 'Todos los campos son obligatorios';
      return;
    }

    const payload = {
      titulo: this.nuevoLibro.titulo,
      genero: this.nuevoLibro.genero,
      anioPublicacion: this.nuevoLibro.anioPublicacion,
      autor: {
        nombre: this.nuevoAutor.nombre,
        nacionalidad: this.nuevoAutor.nacionalidad,
        fechaNacimiento: this.nuevoAutor.fechaNacimiento
      }
    };

    console.log('PAYLOAD:', payload);

    this.libroService.create(payload).subscribe(() => {
      this.reset();
      this.loadLibros();
    });
  }

  delete(id: number) {
    if (confirm('¿Seguro que quieres eliminar este libro?')) {
      this.libroService.delete(id).subscribe(() => {
        this.loadLibros();
      });
    }
  }

  startEdit(libro: any) {
    this.editando = { ...libro };
  }

  update() {
    this.libroService.update(this.editando.id, this.editando).subscribe(() => {
      this.editando = null;
      this.loadLibros();
    });
  }

  reset() {
    this.nuevoLibro = {
      titulo: '',
      genero: '',
      anioPublicacion: ''
    };

    this.nuevoAutor = {
      nombre: '',
      nacionalidad: '',
      fechaNacimiento: ''
    };
  }


  filtrarLibros() {
  const texto = this.searchLibros.toLowerCase();

  this.librosFiltrados = this.libros.filter(l =>
    l.id.toString().includes(texto) ||
    l.titulo?.toLowerCase().includes(texto) ||
    l.autor?.nombre?.toLowerCase().includes(texto)
  );
}
}